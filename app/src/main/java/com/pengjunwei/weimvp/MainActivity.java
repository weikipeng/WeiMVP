package com.pengjunwei.weimvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.jakewharton.rxbinding2.view.RxView;
import com.pengjunwei.mvp.MvpActivity;
import com.pengjunwei.weimvp.dao.CPresenter;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

/**
 * Created by wikipeng on 2017/8/3.
 */
public class MainActivity extends MvpActivity {

    protected Button mButtonSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonSend = (Button) findViewById(R.id.buttonSend);
        testRx();
    }


    public void testRx() {
        CPresenter presenter = new CPresenter();
        presenter.print();
        RxView.clicks(mButtonSend).subscribe(new Consumer<Object>() {
            @Override
            public void accept(@NonNull Object o) throws Exception {

            }
        });
    }
}
