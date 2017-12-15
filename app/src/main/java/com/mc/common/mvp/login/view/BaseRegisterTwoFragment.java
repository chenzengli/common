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
public abstract class BaseRegisterTwoFragment extends BaseFragment {


    @BindView(R.id.tv_register_username)
    protected TextView tvRegisterUsername;
    @BindView(R.id.et_code)
    protected EditText etCode;
    @BindView(R.id.til_code)
    protected TextInputLayout tilCode;
    @BindView(R.id.tv_get_code)
    protected TextView tvGetCode;
    @BindView(R.id.btn_send_code)
    protected Button btnSendCode;
    Unbinder unbinder;

    public BaseRegisterTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_register_two;
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

    @OnClick({R.id.tv_get_code, R.id.btn_send_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_get_code:
                getCode();
                break;
            case R.id.btn_send_code:
                checkCode();
                break;
        }
    }

    public abstract void checkCode();

    public abstract void getCode();
}
