package com.orange.cc;

import android.app.Application;
import android.content.Context;
import android.os.Handler;


/**
 * Created by c.c on 2017/2/26.
 * 应用Application基类
 */
public class MyApplication extends Application {
    public static MyApplication softApplication;
    private Handler handler;


    //构造方法
    public MyApplication() {

    }

    @Override
    public void onCreate() {
        softApplication = this;
        super.onCreate();
//        //初始化极光服务
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        MultiDex.install(this);
    }

    //实例化一次
    public synchronized static MyApplication getInstance() {
        if (null == softApplication) {
            softApplication = new MyApplication();
        }
        return softApplication;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }


    /**
     * 强制升级时调用的退出方法
     */
    public void exit() {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}
