package com.mc.common.util;

import android.support.v4.util.ArrayMap;

import rx.Subscription;

/**
 * Created by momologo on 2017/11/21.
 *
 * @author momologo
 */

public class SubscribeManager implements ISubscribeManager {

    private static SubscribeManager manager;
    private ArrayMap<String, Subscription> subscriberArrayMap;

    private SubscribeManager() {
        subscriberArrayMap = new ArrayMap<>();
    }

    public static synchronized SubscribeManager getInstance() {
        if (manager == null) {
            manager = new SubscribeManager();
        }
        return manager;
    }

    @Override
    public void add(String tag, Subscription subscriber) {
        subscriberArrayMap.put(tag, subscriber);
    }

    @Override
    public void remove(String tag) {
        if (subscriberArrayMap.containsKey(tag)) {
            subscriberArrayMap.remove(tag);
        }
    }

    @Override
    public void removeAll() {
        subscriberArrayMap.clear();
    }

    @Override
    public void cancel(String tag) {
        if (subscriberArrayMap.containsKey(tag)) {
            Subscription subscriber = subscriberArrayMap.get(tag);
            if (subscriber != null && !subscriber.isUnsubscribed()) {
                subscriber.unsubscribe();
            }
            subscriberArrayMap.remove(tag);
        }
    }

    @Override
    public void cancelAll() {
        for (String tag : subscriberArrayMap.keySet()) {
            Subscription subscriber = subscriberArrayMap.get(tag);
            if (!subscriber.isUnsubscribed()) {
                subscriber.unsubscribe();
            }
        }
        subscriberArrayMap.clear();
    }
}
