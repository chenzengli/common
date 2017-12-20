package com.mc.common.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mc.common.R;
import com.yuyh.library.imgsel.ImageLoader;

/**
 * Created by momologo on 2017/12/18 11:14.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class CommonImageLoader implements ImageLoader {
    @Override
    public void displayImage(Context context, String path, ImageView imageView) {
        Glide.with(context).load(path).placeholder(R.drawable.ic_default_pic).error(R.drawable.ic_default_pic).into(imageView);
    }
}
