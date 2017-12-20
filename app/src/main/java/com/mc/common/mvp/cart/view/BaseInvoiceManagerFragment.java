package com.mc.common.mvp.cart.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseInvoiceManagerFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener {


    @BindView(R.id.rb_personal)
    protected RadioButton rbPersonal;
    @BindView(R.id.rb_enterprise)
    protected RadioButton rbEnterprise;
    @BindView(R.id.rb_no_need)
    protected RadioButton rbNoNeed;
    @BindView(R.id.rg_invoice_type)
    protected RadioGroup rgInvoiceType;
    @BindView(R.id.et_invoice_title)
    protected EditText etInvoiceTitle;
    @BindView(R.id.et_invoice_id)
    protected EditText etInvoiceId;
    Unbinder unbinder;

    public BaseInvoiceManagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_invoice_manager;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void initView() {
        rgInvoiceType.setOnCheckedChangeListener(this);
        rgInvoiceType.check(R.id.rb_personal);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_enable)
    public void onViewClicked() {
        switch (rgInvoiceType.getCheckedRadioButtonId()) {
            case R.id.rb_personal:
                onEnable("1", null, null);
                break;
            case R.id.rb_enterprise:
                String title = etInvoiceTitle.getText().toString().trim();
                if (TextUtils.isEmpty(title)) {
                    ToastUtils.showShort(R.string.invoice_title_null);
                    return;
                }
                String id = etInvoiceId.getText().toString().trim();
                if (TextUtils.isEmpty(id)) {
                    ToastUtils.showShort(R.string.invoice_id_null);
                    return;
                }
                onEnable("2", title, id);
                break;
            case R.id.rb_no_need:
                onEnable("3", null, null);
                break;
        }
    }

    /**
     * @param type  1个人 2企业 3无需发票
     * @param title type==2时为发票抬头 其他为null
     * @param id    type==2时为纳税人识别号，其他为null
     */
    public abstract void onEnable(String type, String title, String id);

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (group.getCheckedRadioButtonId()) {
            case R.id.rb_personal:
                etInvoiceTitle.setVisibility(View.GONE);
                etInvoiceId.setVisibility(View.GONE);
                break;
            case R.id.rb_enterprise:
                etInvoiceTitle.setVisibility(View.VISIBLE);
                etInvoiceId.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_no_need:
                etInvoiceTitle.setVisibility(View.GONE);
                etInvoiceId.setVisibility(View.GONE);
                break;
        }
    }
}
