package com.panoslice.zyephr.data;

import android.content.Context;

import com.google.gson.Gson;
import com.panoslice.zyephr.data.local.db.DbHelper;
import com.panoslice.zyephr.data.local.prefs.PreferencesHelper;
import com.panoslice.zyephr.data.model.api.BookResponse;
import com.panoslice.zyephr.data.model.db.FormEntity;
import com.panoslice.zyephr.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final ApiHelper mApiHelper;

    private final Context mContext;

    private final DbHelper mDbHelper;

    private final Gson mGson;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, PreferencesHelper preferencesHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        mDbHelper = dbHelper;
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
        mGson = gson;
    }

    @Override
    public Observable<BookResponse> getBookResponse() {
        return mApiHelper.getBookResponse();
    }

    @Override
    public Observable<Boolean> insert(FormEntity formEntity) {
        return mDbHelper.insert(formEntity);
    }

    @Override
    public Observable<Boolean> update(FormEntity formEntity) {
        return mDbHelper.update(formEntity);
    }

    @Override
    public Observable<Boolean> delete(FormEntity formEntity) {
        return mDbHelper.delete(formEntity);
    }

    @Override
    public Observable<Boolean> insertAll(List<FormEntity> formEntityList) {
        return mDbHelper.insertAll(formEntityList);
    }

    @Override
    public Observable<List<FormEntity>> fetchAllReport() {
        return mDbHelper.fetchAllReport();
    }
}
