package com.mc.common.mvp.address.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.view.ContainsEmojiEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BaseEditAddressFragment} factory method to
 * create an instance of this fragment.
 */
public abstract class BaseEditAddressFragment extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    @BindView(R.id.et_receiver_name)
    protected ContainsEmojiEditText etReceiverName;
    @BindView(R.id.et_receiver_phone)
    protected EditText etReceiverPhone;
    @BindView(R.id.tv_choose_area)
    protected TextView tvChooseArea;
    @BindView(R.id.et_detail)
    protected ContainsEmojiEditText etDetail;
    @BindView(R.id.st_default)
    protected Switch stDefault;
    @BindView(R.id.rl_default)
    protected RelativeLayout rlDefault;
    @BindView(R.id.btn_save)
    protected Button btnSave;
    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public final int LayoutId() {
        return R.layout.fragment_base_edit_address;
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

    @OnClick({R.id.tv_choose_area, R.id.btn_save})
    public final void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_choose_area:
                openArea();
                break;
            case R.id.btn_save:
                String receiverName = etReceiverName.getText().toString();
                if (TextUtils.isEmpty(receiverName) || receiverName.length() < 2) {
                    ToastUtils.showShort(R.string.name_too_short);
                    return;
                }
                String phone = etReceiverPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone) || !RegexUtils.isMobileExact(phone)) {
                    ToastUtils.showShort(R.string.phone_not_valid);
                    return;
                }
                String area = tvChooseArea.getText().toString().trim();
                if (TextUtils.isEmpty(area)) {
                    ToastUtils.showShort(R.string.area_not_choose);
                    return;
                }
                String address = etDetail.getText().toString().trim();
                if (TextUtils.isEmpty(address)) {
                    ToastUtils.showShort(R.string.address_too_short);
                    return;
                }
                saveAddress(receiverName, phone, area, address, stDefault.isChecked());
                break;
        }
    }

    public abstract void saveAddress(String name, String phone, String area, String address, boolean isChecked);

    public abstract void openArea();
}
