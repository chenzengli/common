package com.mc.common.mvp.login.view;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.RegexUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseRegisterOneFragment extends BaseFragment {


    @BindView(R.id.et_username)
    protected EditText etUsername;
    @BindView(R.id.til_username)
    protected TextInputLayout tilUsername;
    @BindView(R.id.btn_send_code)
    protected Button btnSendCode;
    Unbinder unbinder;

    public BaseRegisterOneFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_register_one;
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

    @OnClick(R.id.btn_send_code)
    public void onViewClicked() {
        String username = etUsername.getText().toString().trim();
        if (RegexUtils.isMobileExact(username)) {
            sendSMSCode(username);
        } else if (RegexUtils.isEmail(username)) {
            sendEmailCode(username);
        } else {
            tilUsername.setError(getString(R.string.error_register_username));
        }
    }

    public abstract void sendSMSCode(String mobile);

    public abstract void sendEmailCode(String email);

}
