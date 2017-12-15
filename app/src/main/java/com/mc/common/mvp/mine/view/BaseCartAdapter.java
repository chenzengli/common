package com.mc.common.mvp.mine.view;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/12/14 11:26.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public abstract class BaseCartAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_SHOP = 0;

    public static final int TYPE_GOODS = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */
    public BaseCartAdapter() {
        super(new ArrayList<MultiItemEntity>());
    }
}
