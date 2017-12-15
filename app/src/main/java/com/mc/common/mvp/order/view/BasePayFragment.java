package com.mc.common.mvp.order.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.mvp.order.bean.WeChatBean;
import com.mc.common.mvp.order.model.AliPayTools;
import com.mc.common.mvp.order.model.OnRequestListener;
import com.mc.common.mvp.order.model.WeChatPayTools;
import com.unionpay.UPPayAssistEx;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BasePayFragment extends BaseFragment implements OnRequestListener {

    private static final int SDK_PAY_FLAG = 1;

    @BindView(R.id.tv_order_amount)
    TextView tvOrderAmount;
    @BindView(R.id.rb_ali)
    RadioButton rbAli;
    @BindView(R.id.rb_wechat)
    RadioButton rbWechat;
    @BindView(R.id.rb_union)
    RadioButton rbUnion;
    @BindView(R.id.group_pay)
    RadioGroup groupPay;
    @BindView(R.id.btn_pay)
    Button btnPay;
    Unbinder unbinder;

    public BasePayFragment() {
        // Required empty public constructor
    }


    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_pay;
    }

    @Override
    public final void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_pay)
    public void onViewClicked() {
        switch (groupPay.getCheckedRadioButtonId()) {
            case R.id.rb_ali:
                onAliPay();
                break;
            case R.id.rb_wechat:
                onWeChatPay();
                break;
            case R.id.rb_union:
                onUnionPay();
                break;
            default:
        }
    }

    abstract void onAliPay();

    abstract void onWeChatPay();

    abstract void onUnionPay();

    protected void startAliPay(final String orderInfo) {
        AliPayTools.aliPay(getActivity(), orderInfo, this);
    }

    protected void startWeChatPay(WeChatBean weChatBean) {
        WeChatPayTools.doWXPay(getActivity(), getString(R.string.wechat_app_id), weChatBean, this);
    }

    protected void startUnionPay(String tn) {
        // TODO: 2017/12/13 上线后 最后参数改为"00"
        UPPayAssistEx.startPay(getActivity(), null, null, tn.trim(), "01");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         /* ************************************************
         * 步骤3：处理银联手机支付控件返回的支付结果
         ************************************************/
        if (data == null) {
            return;
        }
        /*
         * 支付控件返回字符串:success、fail、cancel 分别代表支付成功，支付失败，支付取消
         */
        String str = data.getExtras().getString("pay_result");
        if (str != null && str.equalsIgnoreCase("success")) {
            //支付成功
        } else if (str != null && str.equalsIgnoreCase("fail")) {
            //支付失败
        } else if (str != null && str.equalsIgnoreCase("cancel")) {
            //取消支付
        }
    }
}
