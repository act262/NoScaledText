package io.micro.noscaledtext.sample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("MainActivity.onCreate");
        System.out.println("MainActivity getResources() = " + getResources());
        System.out.println("getResources().getDisplayMetrics() = " + getResources().getDisplayMetrics());
        System.out.println("getResources().getConfiguration() = " + getResources().getConfiguration());
        System.out.println("getBeforeInfo() = " + getBeforeInfo());
        System.out.println("getAfterInfo() = " + getAfterInfo());

        setContentView(R.layout.activity_main);
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("MainActivity.onConfigurationChanged");
        System.out.println("newConfig = [" + newConfig + "]");
    }

    public void to1(View view) {
        startActivity(new Intent(this, Main1Activity.class));
    }

    public void to2(View view) {
        startActivity(new Intent(this, Main2Activity.class));
    }
}
