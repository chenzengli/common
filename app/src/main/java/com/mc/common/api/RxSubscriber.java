package com.mc.common.api;


import rx.Subscriber;

/**
 * RxJava订阅者Subscriber封装扩展
 *
 * @author huchiwei
 * @version 1.0.0
 */
public abstract class RxSubscriber<T> extends Subscriber<T> {

    @Override
    public void onCompleted() {
        // 忽略操作，需要可覆写该方法
    }

    @Override
    public void onError(Throwable e) {
//        if (e instanceof HttpException) {
//            String errNetwork = AppUtil.getContext().getResources().getString(R.string.err_network);
//            LogUtils.e("onError: " + errNetwork);
//            ToastUtils.showToast(AppUtil.getContext(), errNetwork);
//        } else if (e instanceof TimeoutException) {
//            String timeOut = "请求网络超时";
//            ToastUtils.showToast(AppUtil.getContext(), timeOut);
//        } else if (e instanceof SocketTimeoutException) {
//            ToastUtils.showToast(AppUtil.getContext(), "网络中断，请检查您的网络状态");
//        } else if (e instanceof ConnectException) {
//            ToastUtils.showToast(AppUtil.getContext(), "网络中断，请检查您的网络状态");
//        } else if (e instanceof JsonSyntaxException) {
//            //ToastUtils.showToast(AppUtil.getContext(), "GSON解析失败");
//        } else {
//            // ToastUtils.showToast(AppUtil.getContext(), "error:" + e.getMessage());
//        }

        // TODO: 处理其它通用错误
        // 覆写此方法自行处理异常，通用异常使用super.onError(e)保留
        e.printStackTrace();
    }

    @Override
    public void onNext(T t) {
//        if (t instanceof BaseBean) {
//            BaseBean response = (BaseBean) t;
//            // 判断是否请求错误，出错直接转到onError()
//            if (!response.result.equalsIgnoreCase("01")) {
//                Throwable e = new Throwable(AppUtil.getContext().getResources().getString(R.string.err_default));
//                this.onError(e);
//                return;
//            }
//        }
        onSuccess(t);
    }

    /**
     * 请求成功回调
     *
     * @param t 最终响应结果
     */
    public abstract void onSuccess(T t);
}
