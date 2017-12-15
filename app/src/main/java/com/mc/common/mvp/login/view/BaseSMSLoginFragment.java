package com.mc.common.mvp.login.view;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseSMSLoginFragment extends BaseFragment {


    @BindView(R.id.et_username)
    protected EditText etUsername;
    @BindView(R.id.til_username)
    protected TextInputLayout tilUsername;
    @BindView(R.id.et_sms)
    protected EditText etSms;
    @BindView(R.id.til_sms)
    protected TextInputLayout tilSms;
    @BindView(R.id.tv_get_sms)
    protected TextView tvGetSms;
    @BindView(R.id.tv_go_register)
    protected TextView tvGoRegister;
    @BindView(R.id.tv_forget_pwd)
    protected TextView tvForgetPwd;
    @BindView(R.id.btn_sms_login)
    protected Button btnSmsLogin;
    Unbinder unbinder;

    public BaseSMSLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_smslogin;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_get_sms, R.id.tv_go_register, R.id.tv_forget_pwd, R.id.btn_sms_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_sms:
                getSMS();
                break;
            case R.id.tv_go_register:
                goRegister();
                break;
            case R.id.tv_forget_pwd:
                forgetPwd();
                break;
            case R.id.btn_sms_login:
                loginBySMS(etUsername.getText().toString().trim(), etSms.getText().toString().trim());
                break;
        }
    }


    public abstract void getSMS();

    public abstract void goRegister();

    public abstract void forgetPwd();

    public abstract void loginBySMS(String username, String sms);
}
