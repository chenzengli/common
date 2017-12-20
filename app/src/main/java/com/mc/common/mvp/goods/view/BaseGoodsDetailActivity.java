package com.mc.common.mvp.goods.view;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.base.BaseActivity;
import com.youth.banner.Banner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public abstract class BaseGoodsDetailActivity extends BaseActivity {

    @BindView(R.id.tb_tv_title)
    protected TextView tbTvTitle;
    @BindView(R.id.tb_product_title)
    protected Toolbar tbProductTitle;
    @BindView(R.id.banner_product)
    protected Banner bannerProduct;
    @BindView(R.id.tv_product_name)
    protected TextView tvProductName;
    @BindView(R.id.tv_product_price)
    protected TextView tvProductPrice;
    @BindView(R.id.tv_isFreePd)
    protected TextView tvIsFreePd;
    @BindView(R.id.tv_product_stock)
    protected TextView tvProductStock;
    @BindView(R.id.tv_service_support)
    protected TextView tvServiceSupport;
    @BindView(R.id.tv_freight_detail)
    protected TextView tvFreightDetail;
    @BindView(R.id.tv_receive_coupons)
    protected TextView tvReceiveCoupons;
    @BindView(R.id.tv_get_points)
    protected TextView tvGetPoints;
    @BindView(R.id.tv_product_evaluate)
    protected TextView tvProductEvaluate;
    @BindView(R.id.tv_product_properties)
    protected TextView tvProductProperties;
    @BindView(R.id.tab_product)
    protected TabLayout tabProduct;
    @BindView(R.id.vp_content)
    protected ViewPager vpContent;
    @BindView(R.id.tv_product_go_shop)
    protected TextView tvProductGoShop;
    @BindView(R.id.tv_product_private_chat)
    protected TextView tvProductPrivateChat;
    @BindView(R.id.tv_product_collection)
    protected TextView tvProductCollection;
    @BindView(R.id.tv_add_shopping_cart)
    protected TextView tvAddShoppingCart;
    @BindView(R.id.tv_buy_now)
    protected TextView tvBuyNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_goods_detail);
        ButterKnife.bind(this);
    }

    @Override
    public int LayoutId() {
        return R.layout.activity_base_goods_detail;
    }

    @Override
    public void initView() {
        ButterKnife.bind(this);
        setSupportActionBar(tbProductTitle);
        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
            tbTvTitle.setText(getString(R.string.product_details));
        }
    }

    @Override
    public void addListener() {

    }

    @OnClick({R.id.tv_service_support, R.id.tv_freight_detail, R.id.tv_receive_coupons, R.id.tv_get_points, R.id.tv_product_evaluate, R.id.tv_product_properties, R.id.tv_product_go_shop, R.id.tv_product_private_chat, R.id.tv_product_collection, R.id.tv_add_shopping_cart, R.id.tv_buy_now})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_service_support:
                goServiceIntroduce();
                break;
            case R.id.tv_freight_detail:
                goExpressFee();
                break;
            case R.id.tv_receive_coupons:
                goCoupon();
                break;
            case R.id.tv_get_points:
                break;
            case R.id.tv_product_evaluate:
                break;
            case R.id.tv_product_properties:
                chooseSku();
                break;
            case R.id.tv_product_go_shop:
                goShop();
                break;
            case R.id.tv_product_private_chat:
                openChat();
                break;
            case R.id.tv_product_collection:
                addCollection();
                break;
            case R.id.tv_add_shopping_cart:
                addCart();
                break;
            case R.id.tv_buy_now:
                goBuy();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ab_search:
                shareContent();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public abstract void shareContent();

    public abstract void goBuy();

    public abstract void addCart();

    public abstract void addCollection();

    public abstract void openChat();

    public abstract void goShop();

    public abstract void chooseSku();

    public abstract void goCoupon();

    public abstract void goExpressFee();

    public abstract void goServiceIntroduce();

}
