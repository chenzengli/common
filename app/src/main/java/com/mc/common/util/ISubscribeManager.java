package com.mc.common.util;

import rx.Subscription;

/**
 * Created by momologo on 2017/11/21.
 *
 * @author momologo
 */

public interface ISubscribeManager {

    void add(String tag, Subscription subscriber);

    void remove(String tag);

    void removeAll();

    void cancel(String tag);

    void cancelAll();
}
