package com.mc.common.mvp.address.view;

import android.text.TextUtils;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.mvp.address.bean.Address;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/9/27.
 *
 * @author momologo
 */

public class AddressAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;

    public static final int TYPE_ADDRESS = 0;

    public AddressAdapter(CompoundButton.OnCheckedChangeListener checkedChangeListener) {
        super(new ArrayList<MultiItemEntity>());
        addItemType(TYPE_ADDRESS, R.layout.item_address);
        this.onCheckedChangeListener = checkedChangeListener;
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        Address.AddrListBean listBean = (Address.AddrListBean) item;
        String namePhone = listBean.getName() + "   " + listBean.getMobile();
        helper.setText(R.id.tv_name_phone, namePhone);
        String detailAddress = listBean.getLocation_addr() + listBean.getDetail_addr();
        helper.setText(R.id.tv_detail_address, detailAddress);
        helper.setOnCheckedChangeListener(R.id.cb_default, null);
        if (TextUtils.equals(listBean.getAddr_state(), "1")) {
            helper.setChecked(R.id.cb_default, true);
        } else {
            helper.setChecked(R.id.cb_default, false);
        }
        helper.setTag(R.id.cb_default, item);
        helper.setOnCheckedChangeListener(R.id.cb_default, onCheckedChangeListener);
        helper.addOnClickListener(R.id.iv_address_edit);
        helper.addOnClickListener(R.id.iv_address_del);
    }
}
