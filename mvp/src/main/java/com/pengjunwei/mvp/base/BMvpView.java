package com.pengjunwei.mvp.base;

import com.pengjunwei.mvp.IPresenter2;
import com.pengjunwei.mvp.IView2;
import com.pengjunwei.mvp.IViewState;

/**
 * Created by wikipeng on 2017/8/4.
 */
public class BMvpView<P extends IPresenter2, D extends IViewState> implements IView2<P, D> {
    @Override
    public void render(IViewState viewState) {

    }
}
