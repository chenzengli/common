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
public abstract class BasePasswordLoginFragment extends BaseFragment {

    @BindView(R.id.et_username)
    protected EditText etUsername;
    @BindView(R.id.til_username)
    protected TextInputLayout tilUsername;
    @BindView(R.id.et_password)
    protected EditText etPassword;
    @BindView(R.id.til_password)
    protected TextInputLayout tilPassword;
    @BindView(R.id.tv_go_register)
    protected TextView tvGoRegister;
    @BindView(R.id.tv_forget_pwd)
    protected TextView tvForgetPwd;
    @BindView(R.id.btn_password_login)
    protected Button btnPasswordLogin;
    Unbinder unbinder;

    public BasePasswordLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_password_login;
    }

    @Override
    public final void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_go_register, R.id.tv_forget_pwd, R.id.btn_password_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_go_register:
                goRegister();
                break;
            case R.id.tv_forget_pwd:
                forgetPassword();
                break;
            case R.id.btn_password_login:
                loginByPassword(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
                break;
        }
    }

    public abstract void goRegister();

    public abstract void forgetPassword();

    public abstract void loginByPassword(String username, String password);
}
