package com.skillvo.android;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class ProjectApplication extends Application {

    private static ProjectApplication projectApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        projectApplication = this;
        setUpDefaultCalligraphy();
    }

    private void setUpDefaultCalligraphy() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

    public static ProjectApplication getApplication(){
        return projectApplication;
    }
}
