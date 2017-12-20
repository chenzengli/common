package com.mc.common.mvp.mine.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseListFragment;
import com.mc.common.base.BasePresenter;
import com.mc.common.mvp.mine.bean.OperateBean;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BasePasswordManagerFragment extends BaseListFragment {

    public static final String mParams1 = "params1";
    Unbinder unbinder;
    private ArrayList<MultiItemEntity> operateBeanList = new ArrayList<>();

    public BasePasswordManagerFragment() {
        // Required empty public constructor
    }

    public static BasePasswordManagerFragment newInstance(ArrayList<OperateBean> data) {

        BasePasswordManagerFragment fragment = new BasePasswordManagerFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(mParams1, data);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ArrayList<OperateBean> beanArrayList = getArguments().getParcelableArrayList(mParams1);
            if (beanArrayList == null) beanArrayList = new ArrayList<>();
            operateBeanList.clear();
            operateBeanList.addAll(beanArrayList);
        }
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

    @Override
    public void initEmpty(View view, TextView tvEmptyView) {

    }

    @Override
    public boolean refreshEnable() {
        return false;
    }

    @Override
    public boolean loadMoreEnable() {
        return false;
    }

    @Override
    public BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getAdapter() {
        return new PasswordManagerAdapter(operateBeanList);
    }

    @OnClick({R.id.tv_manager_one, R.id.tv_manager_two, R.id.tv_manager_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_manager_one:
                break;
            case R.id.tv_manager_two:
                break;
            case R.id.tv_manager_three:
                break;
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {

    }
}
