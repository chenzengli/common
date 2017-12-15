package com.mc.common.mvp.order.view;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;

import java.util.List;

/**
 * Created by momologo on 2017/12/11 11:15.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public abstract class LogisticsAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_LOGISTICS = 0;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public LogisticsAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LOGISTICS, R.layout.item_logistics_info);
    }
}
