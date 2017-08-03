package com.pengjunwei.weimvp;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.pengjunwei.mvp.MvpActivity;

/**
 * Created by wikipeng on 2017/8/3.
 */
public class MainActivity extends MvpActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
