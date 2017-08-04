package com.pengjunwei.weimvp.dao;

import android.util.Log;

import java.lang.reflect.ParameterizedType;

/**
 * Created by wikipeng on 2017/8/4.
 */
public class BPresenter<MVPViewT> {
    private MVPViewT        mvpView;
    private Class<MVPViewT> persistentClass;

    public BPresenter() {
        this.persistentClass = (Class<MVPViewT>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        Log.e("wikipeng", "BPresenter 000 ======>" + persistentClass);
    }

    public void print(){
        Log.e("wikipeng", "BPresenter 111 ======>" + persistentClass);
    }
}
