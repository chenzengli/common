package com.mc.common.mvp.mine.view;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;
import com.mc.common.mvp.mine.bean.OperateBean;

import java.util.List;

/**
 * Created by momologo on 2017/12/18 14:51.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class PasswordManagerAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_OPERATE = 0;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */
    public PasswordManagerAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_OPERATE, R.layout.item_operate);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        if (item.getItemType() == TYPE_OPERATE) {
            OperateBean operateBean = (OperateBean) item;
            TextView tvOperate = helper.getView(R.id.tv_operate_name);
            tvOperate.setText(operateBean.getOperateName());
            tvOperate.setTag(operateBean);
        }
    }
}
