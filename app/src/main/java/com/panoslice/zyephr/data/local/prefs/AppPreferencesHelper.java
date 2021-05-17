package com.panoslice.zyephr.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;
import com.panoslice.zyephr.data.DataManager;
import com.panoslice.zyephr.di.PreferenceInfo;
import com.panoslice.zyephr.utils.AppConstants;
import javax.inject.Inject;



public class AppPreferencesHelper implements PreferencesHelper {

    private final SharedPreferences mPrefs;

    @Inject
    public AppPreferencesHelper(Context context, @PreferenceInfo String prefFileName) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }
}
