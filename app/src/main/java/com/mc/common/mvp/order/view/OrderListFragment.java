package com.mc.common.mvp.order.view;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class OrderListFragment extends BaseListFragment {

    private BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> orderAdapter;

    private int page = 1;

    public OrderListFragment() {
        // Required empty public constructor
    }

    @Override
    public void initEmpty(View view, TextView tvEmptyTip) {
        tvEmptyTip.setText("暂无相关订单");
    }

    @Override
    public boolean refreshEnable() {
        return true;
    }

    @Override
    public boolean loadMoreEnable() {
        return true;
    }

    @Override
    public BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getAddressAdapter() {
        orderAdapter = getAdapter();
        return orderAdapter;
    }

    @Override
    public void onRefresh() {
        page = 1;
        getOrderList(page);
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        onItemSelect(adapter, view, position, orderAdapter.getItem(position));
    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        getOrderList(page);
    }

    public abstract OrderAdapter getAdapter();

    public abstract void getOrderList(int page);

    public abstract void onItemSelect(BaseQuickAdapter adapter, View view, int position, MultiItemEntity itemEntity);
}
