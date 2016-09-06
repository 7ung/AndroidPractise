package com.tunghh.footballdata.views;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by TungHH on 8/22/2016.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        initLayout();
    }

    abstract @LayoutRes int getContentView();
    abstract void initLayout();

    public void showMsg(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
