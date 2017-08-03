package com.pengjunwei.mvp.delegate;

import com.pengjunwei.mvp.IPresenter2;
import com.pengjunwei.mvp.IView2;
import com.pengjunwei.mvp.lifecycle.CommonLifecycle;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface MvpDelegate<V extends IView2, P extends IPresenter2<V>> extends CommonLifecycle {
}
