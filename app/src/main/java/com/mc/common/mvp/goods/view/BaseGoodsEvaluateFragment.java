package com.mc.common.mvp.goods.view;


import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseListFragment;
import com.mc.common.base.BasePresenter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseGoodsEvaluateFragment extends BaseListFragment {

    private TagFlowLayout flowLayout;

    private View headView;

    private ArrayList<String> evaluateCategory = new ArrayList<>();

    private int page = 1;

    public BaseGoodsEvaluateFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {
        super.initView();
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        headView = mInflater.inflate(R.layout.layout_evaluate_head, (ViewGroup) rvContent.getParent(), false);
        flowLayout = headView.findViewById(R.id.flow_evaluate);
        evaluateCategory.add("好评");
        evaluateCategory.add("中评");
        evaluateCategory.add("差评");
        TagAdapter<String> tagAdapter = new TagAdapter<String>(evaluateCategory) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, flowLayout, false);
                tv.setText(s);
                return tv;
            }
        };
        flowLayout.setAdapter(tagAdapter);
        flowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                page = 1;
                switch (position) {
                    case 0:
                        onPraiseChecked();
                        break;
                    case 1:
                        onMiddleChecked();
                        break;
                    case 2:
                        onNegativeChecked();
                        break;
                }
                return false;
            }
        });
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
        tvEmptyView.setText(R.string.evaluate_empty);
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
        BaseGoodDetailAdapter evaluateAdapter = getEvaluateAdapter();
        if (headView != null)
            evaluateAdapter.addHeaderView(headView);
        return evaluateAdapter;
    }

    @Override
    public void onRefresh() {
        page = 1;
        loadList(page);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        loadList(page);
    }

    public abstract BaseGoodDetailAdapter getEvaluateAdapter();

    public abstract void loadList(int page);

    public abstract void onPraiseChecked();

    public abstract void onMiddleChecked();

    public abstract void onNegativeChecked();
}
