package io.micro.noscaledtext.sample;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

public class BaseActivity extends AppCompatActivity {

    private String beforeInfo;
    private String afterInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        beforeInfo = dumpDisplayInfo();
        super.onCreate(savedInstanceState);

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

}
