package com.pengjunwei.mvp;

/**
 * Created by wikipeng on 2017/8/3.
 */
public interface IView2<P extends IPresenter2, D extends IViewState> {
    /**
     * Renders the viewState
     */
    void render(D viewState);
}
