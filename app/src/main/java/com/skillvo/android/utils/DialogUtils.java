package com.skillvo.android.utils;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class DialogUtils {
    private DialogUtils() {
    }

    public static void showToast(Context activityContext, String message) {
        if (activityContext != null) {
            if (!TextUtils.isEmpty(message)) {
                Toast.makeText(activityContext, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void showToast(Context activityContext, int message) {
        if (activityContext != null) {
            Toast.makeText(activityContext, activityContext.getResources().getString(message), Toast.LENGTH_SHORT).show();
        }
    }
}
