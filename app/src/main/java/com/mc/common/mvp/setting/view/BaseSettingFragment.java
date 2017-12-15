package com.mc.common.mvp.setting.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.base.BasePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseSettingFragment extends BaseFragment {


    @BindView(R.id.tv_user_info)
    TextView tvUserInfo;
    @BindView(R.id.tv_receiver_address)
    TextView tvReceiverAddress;
    @BindView(R.id.tv_account_sale)
    TextView tvAccountSale;
    @BindView(R.id.switch_push)
    Switch switchPush;
    @BindView(R.id.switch_disturb)
    Switch switchDisturb;
    @BindView(R.id.rl_disturb)
    RelativeLayout rlDisturb;
    @BindView(R.id.tv_service_protocol)
    TextView tvServiceProtocol;
    @BindView(R.id.tv_privacy_protocol)
    TextView tvPrivacyProtocol;
    @BindView(R.id.tv_above)
    TextView tvAbove;
    @BindView(R.id.tv_help)
    TextView tvHelp;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.tv_clear_cache)
    TextView tvClearCache;
    @BindView(R.id.layout_clear_cache)
    RelativeLayout layoutClearCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.layout_check_update)
    RelativeLayout layoutCheckUpdate;
    @BindView(R.id.btn_logout)
    Button btnLogout;
    @BindView(R.id.ll_setting_main)
    LinearLayout llSettingMain;
    Unbinder unbinder;

    public BaseSettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_setting;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void addListener() {

    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_user_info, R.id.tv_receiver_address, R.id.tv_account_sale, R.id.tv_service_protocol, R.id.tv_privacy_protocol, R.id.tv_above, R.id.tv_help, R.id.tv_feedback, R.id.layout_clear_cache, R.id.layout_check_update, R.id.btn_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_info:
                break;
            case R.id.tv_receiver_address:
                break;
            case R.id.tv_account_sale:
                break;
            case R.id.tv_service_protocol:
                break;
            case R.id.tv_privacy_protocol:
                break;
            case R.id.tv_above:
                break;
            case R.id.tv_help:
                break;
            case R.id.tv_feedback:
                break;
            case R.id.layout_clear_cache:
                break;
            case R.id.layout_check_update:
                break;
            case R.id.btn_logout:
                break;
        }
    }
}
