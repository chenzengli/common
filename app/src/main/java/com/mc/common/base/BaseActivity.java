package com.mc.common.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mc.common.R;
import com.mc.common.dialog.BaseProgressDialog;

public abstract class BaseActivity extends AppCompatActivity {

    private BaseProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LayoutId());
//        PushAgent.getInstance(this).onAppStart();
        initView();
        initData();
        addListener();
    }

    public abstract int LayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract void addListener();

    public void showToast(CharSequence content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(CharSequence content) {
        Toast.makeText(getApplicationContext(), content, Toast.LENGTH_LONG).show();
    }

    public void showProgressDialog() {
        ProgressBar bar = new ProgressBar(this);
        bar.setIndeterminateDrawable(getResources().getDrawable(R.drawable.progressbar));
        progressDialog = BaseProgressDialog.newInstance(this);
        progressDialog.setContentView(bar);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) progressDialog.dismiss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        setContentView(R.layout.activity_none);
        super.onDestroy();
    }

    //-----------------------------------

    protected DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    protected int getWidthPixels() {
        return getDisplayMetrics().widthPixels;
    }

    protected int getHeightPixels() {
        return getDisplayMetrics().heightPixels;
    }

    //-----------------------------------
}
