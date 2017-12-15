package com.mc.common.mvp.login.view;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseRegisterThreeFragment extends BaseFragment {


    @BindView(R.id.et_password)
    protected EditText etPassword;
    @BindView(R.id.til_password)
    protected TextInputLayout tilPassword;
    @BindView(R.id.et_define_password)
    protected EditText etDefinePassword;
    @BindView(R.id.til_define_password)
    protected TextInputLayout tilDefinePassword;
    @BindView(R.id.btn_complete_register)
    protected Button btnCompleteRegister;
    Unbinder unbinder;

    public BaseRegisterThreeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_register_three;
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

    @OnClick(R.id.btn_complete_register)
    public void onViewClicked() {
        String password = etPassword.getText().toString().trim();
        String definePassword = etDefinePassword.getText().toString().trim();
        if (password.length() < 6) {
            tilPassword.setError(getString(R.string.password_short));
        } else if (!TextUtils.equals(password, definePassword)) {
            tilDefinePassword.setError(getString(R.string.password_correct));
        } else {
            completeRegister(password, definePassword);
        }
    }

    public abstract void completeRegister(String password, String definePassword);
}
