package com.orange.cc;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 *Activity基类
 */
public abstract class BaseActivity extends FragmentActivity{
    public Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate ( savedInstanceState );
        initView ();
        initInstall();
        initData();
        evenControl();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
//        AppActivityManager.getAppManager().finishAllActivity();
    }



    /**
     * 初始化布局
     */
    abstract public void initView();

    /***
     * 初始化设置
     */
    abstract public void initInstall();


    /***
     * 初始化数据
     */
    abstract public void initData();


    /***
     * 事件控制
     */
    abstract public void evenControl();




}
