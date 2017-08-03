package com.pengjunwei.mvp.page;


import com.pengjunwei.mvp.IView2;

import io.reactivex.Observable;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface IPageView2 extends IView2 {
    /**
     * The intent to load the first page
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> loadFirstPageIntent();

    /**
     * The intent to load the next page
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> loadNextPageIntent();

    /**
     * The intent to react on pull-to-refresh
     *
     * @return The emitted item boolean can be ignored because it is always true
     */
    Observable<Boolean> pullToRefreshIntent();
}
