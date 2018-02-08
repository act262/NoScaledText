package io.micro.noscaledtext.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author act.zhang
 */
public class Main1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        System.out.println("Main1Activity.onCreate");
        System.out.println("getResources() = " + getResources());
        System.out.println("getResources().getDisplayMetrics() = " + getResources().getDisplayMetrics());
        System.out.println("getResources().getConfiguration() = " + getResources().getConfiguration());
    }
}
