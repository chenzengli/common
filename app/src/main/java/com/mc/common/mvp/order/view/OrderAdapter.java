package com.mc.common.mvp.order.view;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mc.common.R;

import java.util.ArrayList;

/**
 * Created by momologo on 2017/9/28.
 *
 * @author momologo
 */

public abstract class OrderAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    public static final int TYPE_HEAD = 0;

    public static final int TYPE_CONTENT = 1;

    public static final int TYPE_FOOTER = 2;


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     */
    public OrderAdapter() {
        super(new ArrayList<MultiItemEntity>());
        addItemType(TYPE_HEAD, R.layout.item_order_head);
        addItemType(TYPE_CONTENT, R.layout.item_order_content);
        addItemType(TYPE_FOOTER, R.layout.item_order_foot);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        onConvert(helper, item);
    }

    public abstract void onConvert(BaseViewHolder holder, MultiItemEntity itemEntity);
}
