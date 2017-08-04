package com.pengjunwei.mvp.page;

import com.pengjunwei.mvp.base.BMvpView;

import io.reactivex.Observable;

/**
 * Created by wikipeng on 2017/8/4.
 */
public class BPageView<P extends IPagePresenter2> extends BMvpView<P> implements IPageView2 {
    @Override
    public Observable<Boolean> loadFirstPageIntent() {
        return null;
    }

    @Override
    public Observable<Boolean> loadNextPageIntent() {
        return null;
    }

    @Override
    public Observable<Boolean> pullToRefreshIntent() {
        return null;
    }
}
