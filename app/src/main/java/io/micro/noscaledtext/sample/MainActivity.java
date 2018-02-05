package io.micro.noscaledtext.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import io.micro.noscaledtext.ResUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String beforeInfo = dumpDisplayInfo();
        ResUtil.setDefaultDisplay(this);
        String afterInfo = dumpDisplayInfo();

        setContentView(R.layout.activity_main);
        TextView console1TextView = findViewById(R.id.console1);
        TextView console2TextView = findViewById(R.id.console2);
        console1TextView.setText(beforeInfo);
        console2TextView.setText(afterInfo);

        System.out.println("beforeInfo = " + beforeInfo);
        System.out.println("afterInfo = " + afterInfo);
    }

    public String dumpDisplayInfo() {
        StringBuilder builder = new StringBuilder();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        builder.append(displayMetrics);
        return builder.toString();
    }

}
