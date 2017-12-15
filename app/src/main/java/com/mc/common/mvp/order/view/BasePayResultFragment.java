package com.mc.common.mvp.order.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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
public abstract class BasePayResultFragment extends BaseFragment {


    @BindView(R.id.iv_payment_img)
    protected ImageView ivPaymentImg;
    @BindView(R.id.tv_payment_txt)
    protected TextView tvPaymentTxt;
    @BindView(R.id.tv_results_suggest)
    protected TextView tvResultsSuggest;
    @BindView(R.id.btn_complete)
    protected Button btnComplete;
    Unbinder unbinder;

    public BasePayResultFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_pay_result;
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

    @OnClick(R.id.btn_complete)
    public void onViewClicked() {
    }

    protected abstract void onSuccess();

    protected abstract void onFail();

    protected abstract void onCancel();

    protected abstract String onPayState();
}
