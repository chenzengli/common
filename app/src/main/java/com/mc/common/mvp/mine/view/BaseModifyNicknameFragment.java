package com.mc.common.mvp.mine.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.constant.Constant;
import com.mc.common.view.ContainsEmojiEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseModifyNicknameFragment extends BaseFragment {


    @BindView(R.id.et_nickname)
    ContainsEmojiEditText etNickname;
    @BindView(R.id.btn_save)
    Button btnSave;
    Unbinder unbinder;

    public BaseModifyNicknameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_modify_nickname;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        String nickname = SPUtils.getInstance(Constant.SPUtils).getString(Constant.NICKNAME, "");
        etNickname.setText(nickname);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_save)
    public void onViewClicked() {
        String nickname = etNickname.getText().toString().trim();
        if (TextUtils.isEmpty(nickname)) {
            ToastUtils.showShort(R.string.new_nickname_null);
            return;
        }
        onNicknameComplete(nickname);
    }

    public abstract void onNicknameComplete(String nickname);
}
