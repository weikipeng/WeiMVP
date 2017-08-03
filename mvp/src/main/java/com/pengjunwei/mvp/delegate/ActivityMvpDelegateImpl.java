package com.pengjunwei.mvp.delegate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.pengjunwei.mvp.IPresenter2;
import com.pengjunwei.mvp.IView2;
import com.pengjunwei.mvp.MvpDelegateCallback;
import com.pengjunwei.mvp.manager.PresenterManager;

import java.util.UUID;

/**
 * Created by wikipeng on 2017/8/3.
 */
public class ActivityMvpDelegateImpl<V extends IView2, P extends IPresenter2<V>> implements ActivityMvpDelegate<V, P> {

    public static        boolean DEBUG             = false;
    private static final String  DEBUG_TAG         = "ActivityMvpDelegateImpl";
    private static final String  KEY_MOSBY_VIEW_ID = "com.pengjunwei.mvp.id";
    private              String  mosbyViewId       = null;

    private MvpDelegateCallback<V, P> delegateCallback;
    private Activity                  activity;
    private boolean                   keepPresenterInstance;
    private P                         presenter;


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
     * @param activity              The activity
     * @param delegateCallback      The delegate callback
     * @param keepPresenterInstance true, if the presenter instance should be kept through screen
     *                              orientation changes, false if not (a new presenter instance will be created every time you
     *                              rotate your device)
     */
    public ActivityMvpDelegateImpl(@NonNull Activity activity,
                                   @NonNull MvpDelegateCallback<V, P> delegateCallback, boolean keepPresenterInstance) {

        if (activity == null) {
            throw new NullPointerException("Activity is null");
        }

        if (delegateCallback == null) {
            throw new NullPointerException("MvpDelegateCallback is null!");
        }
        this.delegateCallback = delegateCallback;
        this.activity = activity;
        this.keepPresenterInstance = keepPresenterInstance;
    }

    @Override
    public void onCreate(@Nullable Bundle bundle) {
        if (keepPresenterInstance && bundle != null) {
            mosbyViewId = bundle.getString(KEY_MOSBY_VIEW_ID);
        }

        if (DEBUG) {
            Log.d(DEBUG_TAG,
                    "MosbyView ID = " + mosbyViewId + " for MvpView: " + delegateCallback.getMvpView());
        }
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {
        boolean viewStateWillBeRestored = false;

        if (mosbyViewId == null) {
            // No presenter available,
            // Activity is starting for the first time (or keepPresenterInstance == false)
            presenter = createViewIdAndCreatePresenter();
            if (DEBUG) {
                Log.d(DEBUG_TAG, "new Presenter instance created: "
                        + presenter
                        + " for "
                        + delegateCallback.getMvpView());
            }
        } else {
            presenter = PresenterManager.getPresenter(activity, mosbyViewId);
            if (presenter == null) {
                // Process death,
                // hence no presenter with the given viewState id stored, although we have a viewState id
                presenter = createViewIdAndCreatePresenter();
                if (DEBUG) {
                    Log.d(DEBUG_TAG,
                            "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: "
                                    + presenter);
                }
            } else {
                viewStateWillBeRestored = true;
                if (DEBUG) {
                    Log.d(DEBUG_TAG, "Presenter instance reused from internal cache: " + presenter);
                }
            }
        }

        // presenter is ready, so attach viewState
        V view = delegateCallback.getMvpView();
        if (view == null) {
            throw new NullPointerException(
                    "MvpView returned from getMvpView() is null. Returned by " + activity);
        }

        if (viewStateWillBeRestored) {
            delegateCallback.setRestoringViewState(true);
        }

        presenter.attachView(view);

        if (viewStateWillBeRestored) {
            delegateCallback.setRestoringViewState(false);
        }

        if (DEBUG) {
            Log.d(DEBUG_TAG,
                    "MvpView attached to Presenter. MvpView: " + view + "   Presenter: " + presenter);
        }
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    /**
     * Generates the unique (mosby internal) view id and calls {@link
     * MvpDelegateCallback#createPresenter()}
     * to create a new presenter instance
     *
     * @return The new created presenter instance
     */
    private P createViewIdAndCreatePresenter() {

        P presenter = delegateCallback.createPresenter();
        if (presenter == null) {
            throw new NullPointerException(
                    "Presenter returned from createPresenter() is null. Activity is " + activity);
        }
        if (keepPresenterInstance) {
            mosbyViewId = UUID.randomUUID().toString();
            PresenterManager.putPresenter(activity, mosbyViewId, presenter);
        }
        return presenter;
    }
}
