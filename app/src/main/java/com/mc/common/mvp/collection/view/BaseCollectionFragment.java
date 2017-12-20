package com.mc.common.mvp.collection.view;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseListFragment;
import com.mc.common.base.BasePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseCollectionFragment extends BaseListFragment {

    private int page = 1;

    public BaseCollectionFragment() {
        // Required empty public constructor
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
    public void initEmpty(View view, TextView tvEmptyView) {
        tvEmptyView.setText(R.string.collection_empty);
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
    public BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getAdapter() {
        return getCollectionAdapter();
    }

    @Override
    public void onRefresh() {
        page = 1;
        onLoadList(page);
    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        onLoadList(page);
    }

    public abstract void onLoadList(int page);

    public abstract BaseCollectionAdapter getCollectionAdapter();

}
