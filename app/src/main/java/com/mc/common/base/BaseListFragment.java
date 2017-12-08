package com.mc.common.base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseListFragment#} factory method to
 * create an instance of this fragment.
 */
public abstract class BaseListFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BaseMultiItemQuickAdapter.RequestLoadMoreListener, BaseMultiItemQuickAdapter.OnItemClickListener, BaseMultiItemQuickAdapter.OnItemChildClickListener {

    @BindView(R.id.rv_address)
    RecyclerView rvAddress;
    @BindView(R.id.refresh_address)
    SwipeRefreshLayout refreshAddress;
    Unbinder unbinder;

    public BaseListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_address_list;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        if (refreshEnable())
            refreshAddress.setOnRefreshListener(this);
        else
            refreshAddress.setOnRefreshListener(null);
        refreshAddress.setColorSchemeResources(android.R.color.holo_red_light, android.R.color.holo_blue_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvAddress.setLayoutManager(manager);
        BaseMultiItemQuickAdapter addressAdapter = getAddressAdapter();
        rvAddress.setAdapter(addressAdapter);
        if (loadMoreEnable())
            addressAdapter.setOnLoadMoreListener(this, rvAddress);
        addressAdapter.setOnItemClickListener(this);
        addressAdapter.setOnItemChildClickListener(this);
        addressAdapter.setEmptyView(R.layout.empty_common);
        addressAdapter.setHeaderAndEmpty(true);
        TextView _emptyTip = (TextView) addressAdapter.getEmptyView().findViewById(R.id.tv_empty_tip);
        initEmpty(addressAdapter.getEmptyView(), _emptyTip);
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

    public abstract void initEmpty(View view, TextView tvEmptyTip);

    public abstract boolean refreshEnable();

    public abstract boolean loadMoreEnable();

    public abstract BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getAddressAdapter();
}
