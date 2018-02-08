package io.micro.noscaledtext.sample;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import io.micro.noscaledtext.NoScaledUtils;

/**
 * 所有的Activity继承这个就可以实现不会缩放了
 *
 * @author act.zhang
 */
public class BaseActivity extends AppCompatActivity {

    private String beforeInfo;
    private String afterInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeInfo = dumpDisplayInfo();
        // 1. 基类这里重写显示配置
        NoScaledUtils.setDefaultDisplay(this);
        afterInfo = dumpDisplayInfo();

    }

    public String getBeforeInfo() {
        return beforeInfo;
    }

    public String getAfterInfo() {
        return afterInfo;
    }

    public String dumpDisplayInfo() {
        StringBuilder builder = new StringBuilder();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        builder.append(displayMetrics);
        builder.append("\n default: ");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            builder.append(DisplayMetrics.DENSITY_DEVICE_STABLE);
        }
        return builder.toString();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // 2. 如果manifest中配置了 configChanges ，Activity没有重启的情况下需要手动设置下更新显示配置
        NoScaledUtils.setDefaultDisplay(this);
    }
}
