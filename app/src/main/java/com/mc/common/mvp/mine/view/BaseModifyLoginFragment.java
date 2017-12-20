package com.mc.common.mvp.mine.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseModifyLoginFragment extends BaseFragment {


    @BindView(R.id.et_old_pwd)
    protected EditText etOldPwd;
    @BindView(R.id.et_new_pwd)
    protected EditText etNewPwd;
    @BindView(R.id.et_define_pwd)
    protected EditText etDefinePwd;
    @BindView(R.id.btn_complete)
    protected Button btnComplete;
    Unbinder unbinder;

    public BaseModifyLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_modify_login;
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

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
        String oldPassword = etOldPwd.getText().toString().trim();
        if (TextUtils.isEmpty(oldPassword)) {
            ToastUtils.showShort(R.string.old_password_null);
            return;
        }
        String newPassword = etNewPwd.getText().toString().trim();
        if (TextUtils.isEmpty(newPassword)) {
            ToastUtils.showShort(R.string.new_password_null);
            return;
        }
        if (newPassword.length() < 6) {
            ToastUtils.showShort(R.string.new_password_length);
            return;
        }
        String definePassword = etDefinePwd.getText().toString().trim();
        if (TextUtils.equals(newPassword, definePassword)) {
            ToastUtils.showShort(R.string.new_define_not_equal);
            return;
        }
        onSave(oldPassword, newPassword);
    }

    public abstract void onSave(String oldPassword, String newPassword);
}
