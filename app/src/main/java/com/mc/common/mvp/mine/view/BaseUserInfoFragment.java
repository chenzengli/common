package com.mc.common.mvp.mine.view;


import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.mc.common.R;
import com.mc.common.base.BaseFragment;
import com.mc.common.constant.Constant;
import com.mc.common.util.CommonImageLoader;
import com.mc.common.view.CircleImageView;
import com.yuyh.library.imgsel.ImageLoader;
import com.yuyh.library.imgsel.ImgSelActivity;
import com.yuyh.library.imgsel.ImgSelConfig;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.util.ConvertUtils;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseUserInfoFragment extends BaseFragment {


    @BindView(R.id.iv_user_avatar)
    protected CircleImageView ivUserAvatar;
    @BindView(R.id.tv_user_name)
    protected TextView tvUserName;
    @BindView(R.id.tv_nick_name)
    protected TextView tvNickName;
    @BindView(R.id.tv_user_sex)
    protected TextView tvUserSex;
    @BindView(R.id.tv_user_birthday)
    protected TextView tvUserBirthday;
    Unbinder unbinder;

    private ImageLoader imageLoader = new CommonImageLoader();

    private static final int REQUEST_IMAGE = 12;

    public BaseUserInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int LayoutId() {
        return R.layout.fragment_base_user_info;
    }

    @Override
    public void addInject(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rl_user_avatar, R.id.rl_username, R.id.rl_nickname, R.id.rl_sex, R.id.rl_user_birthday})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_user_avatar:
                ImgSelConfig config = new ImgSelConfig.Builder(getActivity(), imageLoader)
                        // 是否多选

                        .multiSelect(false)

                        .rememberSelected(false)

                        .btnText("确定")

                        // 确定按钮背景色

                        //.btnBgColor(Color.parseColor(""))

                        // 确定按钮文字颜色

                        .btnTextColor(Color.WHITE)

                        // 使用沉浸式状态栏

                        .statusBarColor(Color.parseColor("#d71827"))

                        // 返回图标ResId
                        .backResId(R.drawable.ic_arrow_back_black_24dp)

                        .title("修改头像")

                        .titleColor(Color.WHITE)

                        .titleBgColor(Color.parseColor("#d71827"))

                        .allImagesText("全部")

                        .needCrop(true)

                        .cropSize(1, 1, 500, 500)

                        // 第一个是否显示相机

                        .needCamera(true)

                        // 最大选择图片数量

                        .maxNum(1)

                        .build();

                ImgSelActivity.startActivity(this, config, REQUEST_IMAGE);
                break;
            case R.id.rl_username:
                ToastUtils.showShort(R.string.username_not_edit);
                break;
            case R.id.rl_nickname:
                final EditText editText = new EditText(getActivity());
                new AlertDialog.Builder(getActivity()).setTitle(R.string.edit_nickname).setView(editText).setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        onNickNameComplete(editText.getText().toString().trim());
                    }
                }).setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
                break;
            case R.id.rl_sex:
                OptionPicker picker = new OptionPicker(getActivity(), new String[]{
                        "男", "女", "保密"
                });
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(11);
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int index, String item) {
                        onSexSelected(index, item);
                    }
                });
                picker.show();
                break;
            case R.id.rl_user_birthday:
                final DatePicker datePicker = new DatePicker(getActivity());
                datePicker.setCanceledOnTouchOutside(true);
                datePicker.setUseWeight(true);
                datePicker.setTopPadding(ConvertUtils.toPx(getActivity(), 10));
                datePicker.setTextColor(getResources().getColor(R.color.colorAccent));
                datePicker.setCancelTextColor(getResources().getColor(R.color.colorAccent));
                datePicker.setSubmitTextColor(getResources().getColor(R.color.colorAccent));
                datePicker.setTopLineColor(getResources().getColor(R.color.colorAccent));
                datePicker.setDividerColor(getResources().getColor(R.color.colorAccent));
                Calendar calendar = Calendar.getInstance();
                datePicker.setRangeEnd(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
                datePicker.setRangeStart(1949, 10, 1);
                int[] xx = getDefaultBirthday();
                datePicker.setSelectedItem(xx[0], xx[1], xx[2]);
                datePicker.setResetWhileWheel(false);
                datePicker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        String birthday = year + "-" + month + "-" + day;
                        onBirthdaySelected(birthday);
//                        tvUserBirthday.setText(birthday);
//                        SPUtils.getInstance(Constant.appName).put(Constant.BIRTHDAY, birthday);
                    }
                });
                datePicker.show();
                break;
        }
    }

    private int[] getDefaultBirthday() {
        String birthday = SPUtils.getInstance(Constant.SPUtils).getString(Constant.BIRTHDAY);
        if (TextUtils.isEmpty(birthday)) {
            return new int[]{1980, 1, 1};
        } else {
            try {
                String[] data = birthday.split("-");
                int[] date = new int[data.length];
                for (int i = 0; i < data.length; i++) {
                    date[i] = Integer.parseInt(data[i]);
                }
                return date;
            } catch (Exception e) {
                return new int[]{1980, 1, 1};
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                // 获取返回的图片列表
                List<String> pathList = data.getStringArrayListExtra(ImgSelActivity.INTENT_RESULT);
                // 处理你自己的逻辑 ....
                if (pathList != null && pathList.size() != 0) {
                    onAvatarSelected(pathList.get(0));
                }
            }
        }
    }

    public abstract void onAvatarSelected(String userIcon);

    public abstract void onSexSelected(int index, String item);

    public abstract void onBirthdaySelected(String birthday);

    public abstract void onNickNameComplete(String nickname);

}
