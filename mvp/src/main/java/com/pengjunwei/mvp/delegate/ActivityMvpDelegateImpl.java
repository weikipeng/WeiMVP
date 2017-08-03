package com.pengjunwei.mvp.delegate;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.pengjunwei.mvp.IPresenter2;
import com.pengjunwei.mvp.IView2;
import com.pengjunwei.mvp.MvpDelegateCallback;

/**
 * Created by wikipeng on 2017/8/3.
 */
public class ActivityMvpDelegateImpl<V extends IView2, P extends IPresenter2<V>> implements ActivityMvpDelegate<V, P> {

    /**
     * Creates a new Delegate with an presenter that survives screen orientation changes
     *
     * @param activity         The activity
     * @param delegateCallback The delegate callback
     */
    public ActivityMvpDelegateImpl(@NonNull Activity activity,
                                   @NonNull MvpDelegateCallback<V, P> delegateCallback) {
        this(activity, delegateCallback, true);
    }

    /**
     * Creates a new delegate
     *
     * @param activity The activity
     * @param delegateCallback The delegate callback
     * @param keepPresenterInstance true, if the presenter instance should be kept through screen
     * orientation changes, false if not (a new presenter instance will be created every time you
     * rotate your device)
     */
    public ActivityMvpDelegateImpl(@NonNull Activity activity,
                                   @NonNull MvpDelegateCallback<V, P> delegateCallback, boolean keepPresenterInstance) {

        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }

        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
//        this.delegateCallback = delegateCallback;
        //        this.activity = activity;
        //        this.keepPresenterInstance = keepPresenterInstance;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }
}
