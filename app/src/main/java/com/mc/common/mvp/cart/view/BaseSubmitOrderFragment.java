package com.mc.common.mvp.cart.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
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
public abstract class BaseSubmitOrderFragment extends BaseFragment {


    @BindView(R.id.tv_no_address)
    protected TextView tvNoAddress;
    @BindView(R.id.tv_receiver_name)
    protected TextView tvReceiverName;
    @BindView(R.id.tv_default_address)
    protected TextView tvDefaultAddress;
    @BindView(R.id.tv_address)
    protected TextView tvAddress;
    @BindView(R.id.rl_address)
    protected RelativeLayout rlAddress;
    @BindView(R.id.rv_submit)
    protected RecyclerView rvSubmit;
    @BindView(R.id.tv_invoice_type)
    protected TextView tvInvoiceType;
    @BindView(R.id.rl_invoice_type)
    protected RelativeLayout rlInvoiceType;
    @BindView(R.id.tv_shop_promotions)
    protected TextView tvShopPromotions;
    @BindView(R.id.rl_shop_promotions)
    protected RelativeLayout rlShopPromotions;
    @BindView(R.id.tv_points_management)
    protected TextView tvPointsManagement;
    @BindView(R.id.rl_express_freight)
    protected RelativeLayout rlExpressFreight;
    @BindView(R.id.et_buyer_message)
    protected EditText etBuyerMessage;
    @BindView(R.id.tv_commodity_price)
    protected TextView tvCommodityPrice;
    @BindView(R.id.rl_total_merchandise)
    protected RelativeLayout rlTotalMerchandise;
    @BindView(R.id.tv_total_merchandise)
    protected TextView tvTotalMerchandise;
    @BindView(R.id.rl_shipping_costs)
    protected RelativeLayout rlShippingCosts;
    @BindView(R.id.tv_discount_money)
    protected TextView tvDiscountMoney;
    @BindView(R.id.rl_discount)
    protected RelativeLayout rlDiscount;
    Unbinder unbinder;

    public BaseSubmitOrderFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_submit_order;
    }

    @Override
    public final void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rvSubmit.setLayoutManager(manager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_address, R.id.rl_invoice_type, R.id.rl_shop_promotions})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_address:
                onSelectAddress();
                break;
            case R.id.rl_invoice_type:
                onSelectInvoice();
                break;
            case R.id.rl_shop_promotions:
                onSelectPromotions();
                break;
        }
    }

    public abstract void onSelectAddress();

    public abstract void onSelectInvoice();

    public abstract void onSelectPromotions();

}
