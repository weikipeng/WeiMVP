package com.pengjunwei.mvp.lifecycle;

import android.os.Bundle;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface ActivityLifecycle extends CommonLifecycle{
    /**
     * This method must be called from {@link Activity#onCreate(Bundle)}.
     * This method internally creates the presenter and attaches the viewState to it.
     */
    void onCreate(Bundle bundle);
}
