package com.mc.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.widget.ProgressBar;

import com.mc.common.R;

/**
 * Created by Genuis on 2017/11/14.
 */

public class BaseProgressDialog extends Dialog {


    public static BaseProgressDialog newInstance(Context context) {

        return new BaseProgressDialog(context);
    }


    public BaseProgressDialog(Context context) {
        this(context, R.style.progress_dialog);
        initUI();
    }

    public BaseProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
        initUI();
    }

    protected BaseProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initUI();
    }


    private void initUI() {
        setContentView(new ProgressBar(getContext()));
        getWindow().getAttributes().gravity = Gravity.CENTER;
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
