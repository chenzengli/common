package com.mc.common.mvp.goods.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.app.App;
import com.mc.common.base.BaseFragment;
import com.mc.common.base.BasePresenter;
import com.mc.common.view.pulluploadmore.MyScrollView;
import com.zzhoujay.richtext.RichText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseGoodDetailFragment extends BaseFragment {

    private static final String ARG_PARAM1 = "param1";
    @BindView(R.id.tv_product_detail)
    protected TextView tvProductDetail;
    @BindView(R.id.scrollView)
    protected MyScrollView scrollView;
    Unbinder unbinder;

    private String mParam1;

    public BaseGoodDetailFragment() {
        // Required empty public constructor
    }

    public static BaseGoodDetailFragment newInstance(String param1) {
        BaseGoodDetailFragment fragment = new BaseGoodDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_good_detail;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        String html = "<html><body>" + mParam1 + "</body></html>";
        tvProductDetail.setMovementMethod(LinkMovementMethod.getInstance());
        RichText.fromHtml(html).into(tvProductDetail);
        scrollView.setScrollListener(new MyScrollView.ScrollListener() {
            @Override
            public void onScrollToBottom() {

            }

            @Override
            public void onScrollToTop() {

            }

            @Override
            public void onScroll(int scrollY) {
                App.isTop = scrollY == 0;
            }

            @Override
            public void notBottom() {

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
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
