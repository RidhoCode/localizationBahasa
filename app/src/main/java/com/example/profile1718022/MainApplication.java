package com.example.profile1718022;

import android.app.Application;
import android.content.Context;

import com.example.profile1718022.Helper.LocaleHelper;

public class MainApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
