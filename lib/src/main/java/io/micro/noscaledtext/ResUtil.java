package io.micro.noscaledtext;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.Display;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;

/**
 * Resource scale util
 */
public class ResUtil {

    public static int getDefaultDensity(int displayId) {
        try {
            IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
            return windowManagerService.getInitialDisplayDensity(displayId);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * Android N+ 可以手动设置显示大小，动态改变density
     */
    public static void setDefaultDisplay(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.fontScale = 1;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            configuration.densityDpi = getDefaultDensity(Display.DEFAULT_DISPLAY);
        }
        resources.updateConfiguration(configuration, null);
    }
}
