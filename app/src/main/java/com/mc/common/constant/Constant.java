package com.mc.common.constant;

import com.mc.common.R;
import com.mc.common.app.App;

/**
 * Created by momologo on 2017/12/5 15:03.
 * <p>
 * Copyright (c) 2017 安徽米创信息科技有限公司  All rights reserved.
 *
 * @author momologo
 */

public class Constant {
    public static final String sBaseUrl = "asdfg";
    private static final String appName = App.getInstance().getString(R.string.app_name);
    public static final String UID = "uid_" + appName;
    public static final String NAME = "name_" + appName;
    public static final String USERNAME = "username_" + appName;
    public static final String GENDER = "gender_" + appName;
    public static final String ICONURL = "iconurl_" + appName;
}
