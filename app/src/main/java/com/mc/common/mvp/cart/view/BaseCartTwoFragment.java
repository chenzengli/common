package com.mc.common.mvp.cart.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * 支持跨店结算
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseCartTwoFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseMultiItemQuickAdapter.RequestLoadMoreListener, BaseMultiItemQuickAdapter.OnItemChildClickListener {
    @BindView(R.id.iv_back)
    AppCompatImageView ivBack;
    @BindView(R.id.tv_head_title)
    TextView tvHeadTitle;
    @BindView(R.id.iv_done)
    AppCompatImageView ivDone;
    @BindView(R.id.tb_cart)
    Toolbar tbCart;
    @BindView(R.id.stub_settle)
    ViewStub stubSettle;
    @BindView(R.id.rv_cart)
    RecyclerView rvCart;
    @BindView(R.id.refresh_cart)
    SwipeRefreshLayout refreshCart;

    private CheckBox cbSettleAll;

    private TextView tvSettleTotal;

    private TextView tvGoSettle;

    Unbinder unbinder;
    private int page = 1;

    public BaseCartTwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_cart;
    }

    @Override
    public void addInject(View view) {

    }

    @Override
    public void initView() {
        ivBack.setVisibility(View.GONE);
        tvHeadTitle.setText("购物车");
        refreshCart.setOnRefreshListener(this);
        refreshCart.setEnabled(refreshEnable());
        refreshCart.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        refreshCart.setPadding(0, 0, 0, 0);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCart.setLayoutManager(manager);
        BaseMultiItemQuickAdapter adapter = getAdapter();
        rvCart.setAdapter(adapter);
        adapter.setOnLoadMoreListener(this, rvCart);
        adapter.setEnableLoadMore(loadMoreEnable());
        adapter.setOnItemChildClickListener(this);
        adapter.setEmptyView(R.layout.empty_common);
        adapter.setHeaderAndEmpty(true);
        TextView _emptyView = adapter.getEmptyView().findViewById(R.id.tv_empty_tip);
        _emptyView.setText("购物车空空如也~\n快去添加吧");
        View view = stubSettle.inflate();
        cbSettleAll = view.findViewById(R.id.cb_select_all);
        tvSettleTotal = view.findViewById(R.id.tv_order_total);
        tvGoSettle = view.findViewById(R.id.tv_cart_settle);
    }

    @Override
    public void onRefresh() {
        page = 1;
        onCartList(page);
    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        onCartList(page);
    }

    public abstract boolean refreshEnable();

    public abstract boolean loadMoreEnable();

    public abstract BaseCartAdapter getAdapter();

    protected abstract void onCartList(int page);

}
