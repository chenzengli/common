package com.mc.common.mvp.scan.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.mc.common.R;
import com.mc.common.mvp.scan.camera.CameraManager;
import com.mc.common.mvp.scan.decoding.CaptureActivityHandler;
import com.mc.common.mvp.scan.decoding.InactivityTimer;
import com.mc.common.mvp.scan.decoding.RGBLuminanceSource;
import com.mc.common.mvp.scan.utils.ScanAsyncTask;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;


/**
 * Initial the camera
 *
 * @author Ryan.Tang
 */
public class CaptureActivity extends AppCompatActivity implements Callback, View.OnClickListener {

    private static final int REQUEST_CODE_SCAN_GALLERY = 100;

    private CaptureActivityHandler handler;
    private ViewfinderView viewfinderView;
    private ImageView back;
    private boolean hasSurface;
    private Vector<BarcodeFormat> decodeFormats;
    private String characterSet;
    private InactivityTimer inactivityTimer;
    private MediaPlayer mediaPlayer;
    private boolean playBeep;
    private static final float BEEP_VOLUME = 0.10f;
    private boolean vibrate;
    private ProgressDialog mProgress;
    private String photo_path;
    private Bitmap scanBitmap;
    //	private Button cancelScanButton;
    public static final int RESULT_CODE_QR_SCAN = 0xA1;
    public static final String INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result";

    private AppCompatImageView ivAlbum, ivLight;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        //添加toolbar
        addToolbar();
        CameraManager.init(getApplication());
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_content);
        hasSurface = false;
        inactivityTimer = new InactivityTimer(this);
        ivAlbum = (AppCompatImageView) findViewById(R.id.iv_album);
        ivAlbum.setOnClickListener(this);
        ivLight = (AppCompatImageView) findViewById(R.id.iv_light);
        ivLight.setOnClickListener(this);
        AppCompatImageView ivBack = (AppCompatImageView) findViewById(R.id.iv_back);
        ivBack.setOnClickListener(this);
    }

    private void addToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_scanner);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_SCAN_GALLERY:
                    //获取选中图片的路径
                    List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                    if (pathList != null && pathList.size() > 0) {
                        photo_path = pathList.get(0);
                    } else {
                        ToastUtils.showShort("您没有选中图片，请再选一次");
                        return;
                    }
//                    Cursor cursor = getContentResolver().query(data.getData(), null, null, null, null);
//                    if (cursor == null) {
//                        return;
//                    }
//                    if (cursor.moveToFirst()) {
//                        photo_path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//                    }
//                    cursor.close();

//                    mProgress = new ProgressDialog(CaptureActivity.this);
//                    mProgress.setMessage("正在扫描...");
//                    mProgress.setCancelable(false);
//                    mProgress.show();

                    ScanAsyncTask scanAsyncTask = new ScanAsyncTask(this);
                    scanAsyncTask.setScanCallback(new ScanAsyncTask.ScanCallback() {
                        @Override
                        public void finish(String text) {
                            if (!TextUtils.isEmpty(text)) {
                                // TODO: 2017/12/12 此处跳转至扫描完成的页面 
//                                Intent intent = new Intent(CaptureActivity.this, ScanResultActivity.class);
//                                intent.putExtra("data", text);
//                                startActivity(intent);
                            } else {
                                ToastUtils.showShort("没有找到内容");
                                Message m = handler.obtainMessage();
                                m.what = R.id.decode_failed;
                                m.obj = "Scan failed!";
                                handler.sendMessage(m);
                            }
                        }
                    });
                    scanAsyncTask.execute(photo_path);
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Result result = scanningImage(photo_path);
//                            if (result != null) {
//                                Intent intent = new Intent(CaptureActivity.this, ScanResultActivity.class);
//                                intent.putExtra("data", result.getText());
//                                startActivity(intent);
////                                Intent resultIntent = new Intent();
////                                Bundle bundle = new Bundle();
////                                bundle.putString(INTENT_EXTRA_KEY_QR_SCAN, result.getText());
////                                resultIntent.putExtras(bundle);
////                                CaptureActivity.this.setResult(RESULT_CODE_QR_SCAN, resultIntent);
//
//                            } else {
////                                ToastUtils.showToast(CaptureActivity.this, "没有找到内容");
//                                Message m = handler.obtainMessage();
//                                m.what = R.id.decode_failed;
//                                m.obj = "Scan failed!";
//                                handler.sendMessage(m);
//                            }
//                        }
//                    }).start();
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 扫描二维码图片的方法
     *
     * @param path
     * @return
     */
    public Result scanningImage(String path) {
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        Hashtable<DecodeHintType, String> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF8"); //设置二维码内容的编码

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 先获取原大小
        scanBitmap = BitmapFactory.decodeFile(path, options);
        options.inJustDecodeBounds = false; // 获取新的大小
        int sampleSize = (int) (options.outHeight / (float) 200);
        if (sampleSize <= 0)
            sampleSize = 1;
        options.inSampleSize = sampleSize;
        scanBitmap = BitmapFactory.decodeFile(path, options);
        RGBLuminanceSource source = new RGBLuminanceSource(scanBitmap);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        try {
            return reader.decode(bitmap1, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.scanner_view);
        SurfaceHolder surfaceHolder = surfaceView.getHolder();
        if (hasSurface) {
            initCamera(surfaceHolder);
        } else {
            surfaceHolder.addCallback(this);
            surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        }
        decodeFormats = null;
        characterSet = null;

        playBeep = true;
        AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
            playBeep = false;
        }
        initBeepSound();
        vibrate = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        CameraManager.get().closeDriver();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    /**
     * Handler scan result
     *
     * @param result
     * @param barcode
     */
    public void handleDecode(Result result, Bitmap barcode) {
        inactivityTimer.onActivity();
        playBeepSoundAndVibrate();
        String resultString = result.getText();
        if (TextUtils.isEmpty(resultString)) {
            Toast.makeText(CaptureActivity.this, "Scan failed!", Toast.LENGTH_SHORT).show();
        } else {
            // TODO: 2017/12/12 此处跳转至扫描完成的页面 
//            Intent intent = new Intent(CaptureActivity.this, ScanResultActivity.class);
//            intent.putExtra("data", resultString);
//            startActivity(intent);
//            Intent resultIntent = new Intent();
//            Bundle bundle = new Bundle();
//            bundle.putString(INTENT_EXTRA_KEY_QR_SCAN, resultString);
//            resultIntent.putExtras(bundle);
//            this.setResult(RESULT_CODE_QR_SCAN, resultIntent);
        }
        CaptureActivity.this.finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.get().openDriver(surfaceHolder);
        } catch (IOException ioe) {
            return;
        } catch (RuntimeException e) {
            return;
        }
        if (handler == null) {
            handler = new CaptureActivityHandler(this, decodeFormats,
                    characterSet);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (!hasSurface) {
            hasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        hasSurface = false;

    }

    public ViewfinderView getViewfinderView() {
        return viewfinderView;
    }

    public Handler getHandler() {
        return handler;
    }

    public void drawViewfinder() {
        viewfinderView.drawViewfinder();

    }

    private void initBeepSound() {
        if (playBeep && mediaPlayer == null) {
            setVolumeControlStream(AudioManager.STREAM_MUSIC);
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setOnCompletionListener(beepListener);

            AssetFileDescriptor file = getResources().openRawResourceFd(R.raw.beep);
            try {
                mediaPlayer.setDataSource(file.getFileDescriptor(), file.getStartOffset(), file.getLength());
                file.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                mediaPlayer = null;
            }
        }
    }

    private static final long VIBRATE_DURATION = 200L;

    private void playBeepSoundAndVibrate() {
        if (playBeep && mediaPlayer != null) {
            mediaPlayer.start();
        }
        if (vibrate) {
            Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
            vibrator.vibrate(VIBRATE_DURATION);
        }
    }

    /**
     * When the beep has finished playing, rewind to queue up another one.
     */
    private final OnCompletionListener beepListener = new OnCompletionListener() {
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    private ImageLoader loader = new ImageLoader() {

        @Override
        public void displayImage(Context context, String path, ImageView imageView) {

            Glide.with(context).load(path).into(imageView);

        }

    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_album:
                //打开手机中的相册
//                Intent innerIntent = new Intent(Intent.ACTION_GET_CONTENT); //"android.intent.action.GET_CONTENT"
//                innerIntent.setType("image/*");
//                Intent wrapperIntent = Intent.createChooser(innerIntent, "选择二维码图片");
//                startActivityForResult(wrapperIntent, REQUEST_CODE_SCAN_GALLERY);

                ImgSelConfig config = new ImgSelConfig.Builder(this, loader)
                        // 是否多选

                        .multiSelect(false)

                        .rememberSelected(false)

                        .btnText("确定")

                        // 确定按钮背景色

                        //.btnBgColor(Color.parseColor(""))

                        // 确定按钮文字颜色

                        .btnTextColor(Color.WHITE)

                        // 使用沉浸式状态栏

                        .statusBarColor(Color.parseColor("#d71827"))

                        // 返回图标ResId
                        .backResId(R.drawable.ic_arrow_back_black_24dp)

                        .title("选取二维码")

                        .titleColor(Color.WHITE)

                        .titleBgColor(Color.parseColor("#d71827"))

                        .allImagesText("全部")

                        .needCrop(false)

                        .cropSize(1, 1, 500, 500)

                        // 第一个是否显示相机

                        .needCamera(false)

                        // 最大选择图片数量

                        .maxNum(1)

                        .build();

                ImgSelActivity.startActivity(this, config, REQUEST_CODE_SCAN_GALLERY);
                break;
            case R.id.iv_light:
                if (CameraManager.get().isFlashlightOn()) {
                    CameraManager.get().operateLight(false);
                    ivLight.setSelected(false);
                } else {
                    CameraManager.get().operateLight(true);
                    ivLight.setSelected(true);
                }
                break;
            case R.id.iv_back:
                onBackPressed();
                break;
        }
    }
}