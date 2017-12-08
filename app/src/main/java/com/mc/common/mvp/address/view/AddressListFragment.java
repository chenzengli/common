package com.mc.common.mvp.address.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.base.BaseListFragment;
import com.mc.common.mvp.address.bean.Address;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddressListFragment} factory method to
 * create an instance of this fragment.
 */
public abstract class AddressListFragment extends BaseListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> addressAdapter;

    private int page = 1;

    public AddressListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }

    @Override
    public void initEmpty(View view, TextView tvEmptyTip) {
        tvEmptyTip.setText(R.string.empty_address);
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
    public BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> getAddressAdapter() {
        OnChecked checked = new OnChecked();
        addressAdapter = new AddressAdapter(checked);
        return addressAdapter;
    }

    @Override
    public void onRefresh() {
        page = 1;
        loadAddressList(page);
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        Address.AddrListBean listBean = (Address.AddrListBean) addressAdapter.getItem(position);
        if (listBean == null) {
            ToastUtils.showShort("未知错误，请稍后再试");
            return;
        }
        switch (view.getId()) {
            case R.id.iv_address_del:
                deleteAddress(String.valueOf(listBean.getAddr_id()));
                break;
            case R.id.iv_address_edit:
                editAddress(listBean);
                break;
        }
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        onAddressSelected(adapter,view,position,addressAdapter.getItem(position));
    }

    @Override
    public void onLoadMoreRequested() {
        page++;
        loadAddressList(page);
    }

    private class OnChecked implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                Address.AddrListBean listBean = (Address.AddrListBean) buttonView.getTag();
                if (listBean != null)
                    setDefault(String.valueOf(listBean.getAddr_id()));
                else
                    ToastUtils.showShort("未知错误，请稍后再试");
            } else {
                buttonView.setOnCheckedChangeListener(null);
                buttonView.setChecked(true);
                buttonView.setOnCheckedChangeListener(this);
            }
        }
    }

    public abstract void loadAddressList(int page);

    public abstract void deleteAddress(String addressId);

    public abstract void setDefault(String addressId);

    public abstract void editAddress(Address.AddrListBean listBean);

    public abstract void onAddressSelected(BaseQuickAdapter adapter, View view, int position, MultiItemEntity multiItemEntity);
}
