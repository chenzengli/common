package com.mc.common.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by momologo on 2017/12/5 15:01.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class App extends Application {

    public static App app;

    public static boolean isTop = false;

    public static Context getInstance() {
        return app;
    }
}
