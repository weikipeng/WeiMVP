package com.pengjunwei.mvp;

import android.support.annotation.NonNull;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface MvpDelegateCallback<V extends IView2, P extends IPresenter2<V>> {
    /**
     * Creates the presenter instance
     *
     * @return the created presenter instance
     */
    @NonNull
    P createPresenter();

    /**
     * Get the MvpView for the presenter
     *
     * @return The viewState associated with the presenter
     */
    @NonNull
    V getMvpView();

    /**
     * This method will be called to inform that restoring
     * the view state is in progress (true as parameter value) and when restoring is finished (false
     * as parameter value). Typically this is set to true when the view is reattached to the
     * presenter
     * after orientation changes or when navigating back from backstack.
     * Usually this is useful if you want to know whether or not you should run certain animations
     * because of the state of the view has changed or the view has been reattached to the presenter
     * (i.e. orientation change, coming back from back stack) and therefore no animations should run.
     *
     * @param restoringViewState true, if restoring view state is in progress, otherwise false
     */
    void setRestoringViewState(boolean restoringViewState);
}
