package com.skillvo.android;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class ProjectApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setUpDefaultCalligraphy();
    }

    private void setUpDefaultCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
