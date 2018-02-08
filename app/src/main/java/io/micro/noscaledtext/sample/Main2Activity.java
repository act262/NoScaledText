package io.micro.noscaledtext.sample;

import android.content.res.Configuration;
import android.os.Bundle;

public class Main2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Main2Activity.onCreate");
        System.out.println("Main2Activity getResources() = " + getResources());
        System.out.println("getResources().getDisplayMetrics() = " + getResources().getDisplayMetrics());
        System.out.println("getResources().getConfiguration() = " + getResources().getConfiguration());
        System.out.println("getBeforeInfo() = " + getBeforeInfo());
        System.out.println("getAfterInfo() = " + getAfterInfo());

        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("Main2Activity.onConfigurationChanged");
        System.out.println("newConfig = [" + newConfig + "]");
    }
}
