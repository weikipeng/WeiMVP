package com.pengjunwei.mvp.lifecycle;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface CommonLifecycle extends Lifecycle {
    void onResume();

    void onStart();

    void onPause();

    void onStop();
}
