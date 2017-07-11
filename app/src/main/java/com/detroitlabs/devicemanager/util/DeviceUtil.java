package com.detroitlabs.devicemanager.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import java.util.Locale;


public class DeviceUtil {

    public static boolean hasGetAccountsPermission(Context context) {
        return ContextCompat.checkSelfPermission(context,
                android.Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED;
    }

    public static void requestGetAccountsPermission(Fragment fragment, int requestCode) {
        fragment.requestPermissions(new String[]{Manifest.permission.GET_ACCOUNTS}, requestCode);
    }

    public static String getSerialNumber() {
        //this is so that emulated devices get some kind of serial value
        return Build.SERIAL.equals("unknown") ? "12345" : Build.SERIAL;
    }

    private static String getSize(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getRealMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        double wi = (double) width / (double) dm.xdpi;
        double hi = (double) height / (double) dm.ydpi;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x + y);
        return String.format(Locale.getDefault(), "%.1f in", screenInches);
    }

    private static String getResolution(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;
        return width + " × " + height + " px";
    }

    private static String getIsSamsung() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung") ? "Yes" : "No";
    }
}

