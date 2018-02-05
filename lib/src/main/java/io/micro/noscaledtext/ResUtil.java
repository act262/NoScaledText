package io.micro.noscaledtext;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

/**
 * Resource scale util
 */
public class ResUtil {

    public static void setDefaultDisplay(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.fontScale = 1;

        resources.updateConfiguration(configuration, null);
    }
}
