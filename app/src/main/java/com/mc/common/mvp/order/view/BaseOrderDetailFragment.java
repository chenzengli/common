package com.mc.common.mvp.order.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
public abstract class BaseOrderDetailFragment extends BaseFragment {


    @BindView(R.id.tv_logistics_msg)
    TextView tvLogisticsMsg;
    @BindView(R.id.tv_logistics_time)
    TextView tvLogisticsTime;
    @BindView(R.id.rl_logistics_view)
    RelativeLayout rlLogisticsView;
    @BindView(R.id.tv_receiver_name)
    TextView tvReceiverName;
    @BindView(R.id.tv_receiver_address)
    TextView tvReceiverAddress;
    @BindView(R.id.iv_shop_logo)
    ImageView ivShopLogo;
    @BindView(R.id.tv_contract_shop)
    TextView tvContractShop;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.rv_order_goods)
    RecyclerView rvOrderGoods;
    @BindView(R.id.tv_order_id)
    TextView tvOrderId;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.tv_pay_way)
    TextView tvPayWay;
    @BindView(R.id.tv_express_title)
    TextView tvExpressTitle;
    @BindView(R.id.tv_express_id)
    TextView tvExpressId;
    @BindView(R.id.tv_invoice_type)
    TextView tvInvoiceType;
    @BindView(R.id.tv_invoice_title)
    TextView tvInvoiceTitle;
    @BindView(R.id.tv_invoice_content)
    TextView tvInvoiceContent;
    @BindView(R.id.tv_good_product)
    TextView tvGoodProduct;
    @BindView(R.id.tv_express_fee)
    TextView tvExpressFee;
    @BindView(R.id.tv_discount_amount)
    TextView tvDiscountAmount;
    @BindView(R.id.tv_coupon_amount)
    TextView tvCouponAmount;
    @BindView(R.id.tv_total_amount)
    TextView tvTotalAmount;
    @BindView(R.id.rl_guess_like)
    RelativeLayout rlGuessLike;
    @BindView(R.id.rv_guess_like)
    RecyclerView rvGuessLike;
    @BindView(R.id.ll_detail_main)
    NestedScrollView llDetailMain;
    Unbinder unbinder;

    public BaseOrderDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_order_detail;
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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_logistics_view, R.id.tv_contract_shop, R.id.tv_order_id, R.id.tv_express_id})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_logistics_view:
                break;
            case R.id.tv_contract_shop:
                break;
            case R.id.tv_order_id:
                break;
            case R.id.tv_express_id:

                break;
        }
    }


}
