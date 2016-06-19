package com.skillvo.android.viewmodel;


import android.app.Activity;
import android.content.Intent;

public interface ActivityViewModel {
    void onCreate(Activity activity);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onResumeActivity(Activity activity);

    void onPauseActivity(Activity activity);

    void onBackPressed(Activity activity);

    void onDestroy();
}
