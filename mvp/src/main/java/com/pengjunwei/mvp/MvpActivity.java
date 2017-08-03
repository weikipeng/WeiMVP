package com.pengjunwei.mvp;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pengjunwei.mvp.delegate.ActivityMvpDelegate;
import com.pengjunwei.mvp.delegate.ActivityMvpDelegateImpl;

/**
 * Created by wikipeng on 2017/8/3.
 */
public class MvpActivity<V extends IView2, P extends IPresenter2<V>> extends AppCompatActivity
        implements MvpDelegateCallback<V, P> {

    private boolean isRestoringViewState = false;

    protected ActivityMvpDelegate<V, P> mvpDelegate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @NonNull
    @Override
    public P createPresenter() {
        return null;
    }

    @NonNull
    @Override
    public V getMvpView() {
        return null;
    }

    @Override
    public void setRestoringViewState(boolean restoringViewState) {

    }

    /**
     * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
     * viewState from presenter.
     *
     * <p><b>Please note that only one instance of mvp delegate should be used per Activity
     * instance</b>.
     * </p>
     *
     * <p>
     * Only override this method if you really know what you are doing.
     * </p>
     *
     * @return {@link ActivityMvpDelegate}
     */
    @NonNull protected ActivityMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ActivityMvpDelegateImpl<V, P>(this, this);
        }

        return mvpDelegate;
    }

}
