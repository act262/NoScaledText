package io.micro.noscaledtext.sample;

import android.app.Application;
import android.content.res.Configuration;

import io.micro.noscaledtext.NoScaledUtils;

/**
 * BaseApplication for test
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        NoScaledUtils.setNonScaled(this);

        System.out.println("App.onCreate");
        System.out.println("getResources() = " + getResources());
        System.out.println("getResources().getDisplayMetrics() = " + getResources().getDisplayMetrics());
        System.out.println("getResources().getConfiguration() = " + getResources().getConfiguration());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 修改系统字体大小、显示大小会触发这个回调，从而更新Resource的各个值
        // App 不会重建，对应的Activity会重建，使用同一个Resource对象

        System.out.println("App.onConfigurationChanged");
        System.out.println("newConfig = [" + newConfig + "]");

    }
}
