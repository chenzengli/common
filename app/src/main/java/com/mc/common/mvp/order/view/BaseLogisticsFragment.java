package com.mc.common.mvp.order.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseLogisticsFragment<T extends LogisticsAdapter> extends BaseFragment {

    @BindView(R.id.tv_logistics_id)
    TextView tvLogisticsId;
    @BindView(R.id.tv_logistics_company)
    TextView tvLogisticsCompany;
    @BindView(R.id.tv_logistics_service)
    TextView tvLogisticsService;
    @BindView(R.id.rv_logistics)
    RecyclerView rvLogistics;
    @BindView(R.id.ll_logistics)
    LinearLayout llLogistics;
    Unbinder unbinder;

    public BaseLogisticsFragment() {
        // Required empty public constructor
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_logistics;
    }

    @Override
    public final void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rvLogistics.setLayoutManager(manager);
        BaseMultiItemQuickAdapter adapter = getLogisticsAdapter();
        rvLogistics.setAdapter(adapter);
        adapter.setEnableLoadMore(false);
        adapter.setEmptyView(R.layout.empty_common);
        adapter.setHeaderAndEmpty(true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_logistics_id, R.id.tv_logistics_service})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_logistics_id:
                onCopyLogisticsId();
                break;
            case R.id.tv_logistics_service:
                onCallExpressService();
                break;
        }
    }

    public abstract T getLogisticsAdapter();

    public abstract void onCopyLogisticsId();

    public abstract void onCallExpressService();

}
