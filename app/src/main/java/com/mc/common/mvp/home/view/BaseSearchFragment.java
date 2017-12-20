package com.mc.common.mvp.home.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.base.BasePresenter;
import com.mc.common.constant.Constant;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseSearchFragment extends BaseFragment {


    @BindView(R.id.tv_hot_search)
    TextView tvHotSearch;
    @BindView(R.id.flow_hot)
    TagFlowLayout flowHot;
    @BindView(R.id.tv_clear_history)
    TextView tvClearHistory;
    @BindView(R.id.flow_recent)
    TagFlowLayout flowRecent;
    @BindView(R.id.tv_no_history)
    TextView tvNoHistory;
    Unbinder unbinder;

    private TagAdapter<String> hotSearchAdapter;

    private List<String> hotSearchData = new ArrayList<>();

    private TagAdapter<String> historyAdapter;

    private List<String> historyData = new ArrayList<>();

    public BaseSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_search;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        Set<String> history = SPUtils.getInstance(Constant.SPUtils).getStringSet(Constant.HISTORY_KEY);
        final LayoutInflater mInflater = LayoutInflater.from(getActivity());
        historyData.clear();
        historyData.addAll(history);
        historyAdapter = new TagAdapter<String>(historyData) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.tv, flowHot, false);
                tv.setText(s);
                return tv;

            }
        };
        flowRecent.setAdapter(historyAdapter);
    }

    @Override
    public void addListener() {

        flowRecent.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                onHistorySelected(historyData.get(position));
                return false;
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_clear_history)
    public void onViewClicked() {
        SPUtils.getInstance(Constant.SPUtils).remove(Constant.HISTORY_KEY);
    }

    public abstract void onHistorySelected(String keyWord);
}
