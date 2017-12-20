package com.mc.common.mvp.collection.view;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/12/19 14:19.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public abstract class BaseCollectionAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_GOODS = 0;

    public static final int TYPE_SHOPS = 1;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */
    public BaseCollectionAdapter() {
        super(new ArrayList<MultiItemEntity>());
        addItemType(TYPE_GOODS, R.layout.item_category_switch1_layout);
        addItemType(TYPE_SHOPS, R.layout.item_collection_shops);
    }
}
