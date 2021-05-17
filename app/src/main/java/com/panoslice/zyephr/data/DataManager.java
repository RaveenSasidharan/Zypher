
package com.panoslice.zyephr.data;

import com.panoslice.zyephr.data.local.db.DbHelper;
import com.panoslice.zyephr.data.local.prefs.PreferencesHelper;
import com.panoslice.zyephr.data.remote.ApiHelper;

public interface DataManager extends  PreferencesHelper, ApiHelper, DbHelper {


}
