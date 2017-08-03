package com.pengjunwei.mvp;

import android.support.annotation.UiThread;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface IPresenter2<V extends IView2> {
    /**
     * Set or attach the view to this presenter
     */
    @UiThread
    void attachView(V view);

    /**
     * Will be called if the view has been destroyed. Typically this method will be invoked from
     * <code>Activity.detachView()</code> or <code>Fragment.onDestroyView()</code>
     */
    @UiThread
    void detachView(boolean retainInstance);
}
