package com.mc.common.mvp.order.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.mvp.order.presenter.BaseOrderPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseOrderDetailFragment extends BaseFragment<BaseOrderPresenter> implements BaseMultiItemQuickAdapter.OnItemChildClickListener {


    @BindView(R.id.tv_logistics_msg)
    protected TextView tvLogisticsMsg;
    @BindView(R.id.tv_logistics_time)
    protected TextView tvLogisticsTime;
    @BindView(R.id.rl_logistics_view)
    protected RelativeLayout rlLogisticsView;
    @BindView(R.id.tv_receiver_name)
    protected TextView tvReceiverName;
    @BindView(R.id.tv_receiver_address)
    protected TextView tvReceiverAddress;
    @BindView(R.id.iv_shop_logo)
    protected ImageView ivShopLogo;
    @BindView(R.id.tv_contract_shop)
    protected TextView tvContractShop;
    @BindView(R.id.tv_shop_name)
    protected TextView tvShopName;
    @BindView(R.id.rv_order_goods)
    protected RecyclerView rvOrderGoods;
    @BindView(R.id.tv_order_id)
    protected TextView tvOrderId;
    @BindView(R.id.tv_order_time)
    protected TextView tvOrderTime;
    @BindView(R.id.tv_pay_way)
    protected TextView tvPayWay;
    @BindView(R.id.tv_express_title)
    protected TextView tvExpressTitle;
    @BindView(R.id.tv_express_id)
    protected TextView tvExpressId;
    @BindView(R.id.tv_invoice_type)
    protected TextView tvInvoiceType;
    @BindView(R.id.tv_invoice_title)
    protected TextView tvInvoiceTitle;
    @BindView(R.id.tv_invoice_content)
    protected TextView tvInvoiceContent;
    @BindView(R.id.tv_good_amount)
    protected TextView tvGoodAmount;
    @BindView(R.id.tv_express_fee)
    protected TextView tvExpressFee;
    @BindView(R.id.tv_discount_amount)
    protected TextView tvDiscountAmount;
    @BindView(R.id.tv_coupon_amount)
    protected TextView tvCouponAmount;
    @BindView(R.id.tv_total_amount)
    protected TextView tvTotalAmount;
    @BindView(R.id.rl_guess_like)
    protected RelativeLayout rlGuessLike;
    @BindView(R.id.rv_guess_like)
    protected RecyclerView rvGuessLike;
    @BindView(R.id.ll_detail_main)
    protected LinearLayout llDetailMain;
    Unbinder unbinder;

    public BaseOrderDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initView() {
        //订单商品列表
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrderGoods.setLayoutManager(manager);
        BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> orderGoodAdapter = getOrderGoodAdapter();
        rvOrderGoods.setAdapter(orderGoodAdapter);
        orderGoodAdapter.setOnItemChildClickListener(this);

        //订单底部推荐的列表
        if (showGuessLike()) {
            if (rlGuessLike.getParent() == null)
                llDetailMain.addView(rlGuessLike);
            if (rvGuessLike.getParent() == null)
                llDetailMain.addView(rvGuessLike);
            LinearLayoutManager manager1 = new LinearLayoutManager(getActivity());
            manager1.setOrientation(LinearLayoutManager.VERTICAL);
            rvGuessLike.setLayoutManager(manager1);
            BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> guessLikeAdapter = getOrderGoodAdapter();
            rvGuessLike.setAdapter(guessLikeAdapter);
            guessLikeAdapter.setOnItemChildClickListener(this);
        } else {
            llDetailMain.removeView(rlGuessLike);
            llDetailMain.removeView(rvGuessLike);
        }
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_order_detail;
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

    @OnClick({R.id.rl_logistics_view, R.id.tv_contract_shop, R.id.tv_order_id, R.id.tv_express_id})
    public final void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_logistics_view:
                openLogistics();
                break;
            case R.id.tv_contract_shop:
                openChat();
                break;
            case R.id.tv_order_id:
                copyOrderId();
                break;
            case R.id.tv_express_id:
                copyExpressId();
                break;
        }
    }

    public abstract void copyOrderId();

    public abstract void copyExpressId();

    public abstract void openChat();

    public abstract void openLogistics();

    public abstract boolean showGuessLike();

    public abstract BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getOrderGoodAdapter();

    public abstract BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getRecommendAdapter();

}
