package com.mc.common.mvp.scan.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;
import com.mc.common.R;
import com.mc.common.dialog.BaseProgressDialog;
import com.mc.common.mvp.scan.decoding.RGBLuminanceSource;

import java.util.Hashtable;

/**
 * Created by momologo on 2017/11/23.
 *
 * @author momologo
 */

public class ScanAsyncTask extends AsyncTask<String, Void, String> {

    private BaseProgressDialog progressDialog;

    private Context context;

    private ScanCallback scanCallback;

    public ScanAsyncTask(Context context) {
        this.context = context;
    }


    public void setScanCallback(ScanCallback scanCallback) {
        this.scanCallback = scanCallback;
    }

    @Override

    protected void onPreExecute() {
        super.onPreExecute();
        ProgressBar bar = new ProgressBar(context);
        bar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.progressbar));
        progressDialog = BaseProgressDialog.newInstance(context);
        progressDialog.setContentView(bar);
        progressDialog.show();
    }


    @Override
    protected String doInBackground(String... strings) {
        String path = strings[0];
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        Hashtable<DecodeHintType, String> hints = new Hashtable<>();
        hints.put(DecodeHintType.CHARACTER_SET, "UTF8"); //设置二维码内容的编码

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 先获取原大小
        Bitmap scanBitmap = BitmapFactory.decodeFile(path, options);
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
            Result result = reader.decode(bitmap1, hints);
            if (result != null) return result.getText();
            else return null;

//            return reader.decode(bitmap1, hints);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
        if (scanCallback != null)
            scanCallback.finish(s);
    }

    public interface ScanCallback {
        void finish(String text);
    }
}
