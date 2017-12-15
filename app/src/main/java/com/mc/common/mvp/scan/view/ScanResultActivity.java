package com.mc.common.mvp.scan.view;

import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScanResultActivity extends BaseActivity implements ScanView {

    @BindView(R.id.iv_back)
    AppCompatImageView ivBack;
    @BindView(R.id.tv_head_title)
    TextView tvHeadTitle;
    @BindView(R.id.iv_done)
    AppCompatImageView ivDone;
    @BindView(R.id.tv_scan_result)
    TextView tvScanResult;
    @BindView(R.id.progress)
    ProgressBar progress;

//    private ScanContract.Presenter presenter;

    private String makeUpId = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public void initToolbar() {
//        super.ivBack = this.ivBack;
//        tvHeadTitle.setText("扫码结果");
//        this.ivDone.setVisibility(View.GONE);
//    }

    @Override
    public int LayoutId() {
        return R.layout.activity_scan_result;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        makeUpId = getIntent().getStringExtra("data");
        if (TextUtils.isEmpty(makeUpId)) {
            onBackPressed();
        } else {
//            presenter = new ScanPresenter(this);
//            presenter.checkScan(SharedPreferencesUtils.getString(this, Constants.USERID), makeUpId);
        }
    }

    @Override
    public void initData() {
    }

    @Override
    public void addListener() {

    }

    @Override
    public void startCheck() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void checkSuccess(String info) {
        progress.setVisibility(View.GONE);
        tvScanResult.setText(info);
    }

    @Override
    public void checkFail(String info) {
        progress.setVisibility(View.GONE);
        tvScanResult.setText(info);
    }

    @Override
    public void checkError(String errorInfo) {
        progress.setVisibility(View.GONE);
        tvScanResult.setText(errorInfo);
    }

    @Override
    protected void onDestroy() {
//        SubscribeManager.getInstance().cancel(Constants.changeProduceStatus);
        super.onDestroy();
    }
}
