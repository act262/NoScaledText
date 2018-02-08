package io.micro.noscaledtext;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.IWindowManager;
import android.view.WindowManagerGlobal;

/**
 * Resource scale util
 */
public class NoScaledUtils {

    @TargetApi(Build.VERSION_CODES.N)
    public static int getDefaultDensity(int displayId) {
        try {
            IWindowManager windowManagerService = WindowManagerGlobal.getWindowManagerService();
            return windowManagerService.getInitialDisplayDensity(displayId);
        } catch (Exception e) {
            return DisplayMetrics.DENSITY_DEVICE_STABLE;
        }
    }

    /**
     * 设置默认的显示值
     */
    public static void setDefaultDisplay(Context context) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.fontScale = 1;

        // Android N+ 可以手动设置显示大小，动态改变density
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            configuration.densityDpi = getDefaultDensity(Display.DEFAULT_DISPLAY);
        }
        resources.updateConfiguration(configuration, null);
    }
}
