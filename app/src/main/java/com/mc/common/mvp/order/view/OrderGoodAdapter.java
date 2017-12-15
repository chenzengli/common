package com.mc.common.mvp.order.view;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mc.common.R;
import com.mc.common.base.BaseItemBean;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/12/8 15:14.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public abstract class OrderGoodAdapter extends BaseQuickAdapter<BaseItemBean,BaseViewHolder> {

    public OrderGoodAdapter() {
        super(R.layout.item_order_good, new ArrayList<BaseItemBean>());
    }
}
