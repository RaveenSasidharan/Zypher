package com.panoslice.zyephr.data.local.db;

import android.icu.text.UFormat;

import com.panoslice.zyephr.data.model.db.FormEntity;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;

@Singleton
public class AppDbHelper implements DbHelper {

    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }


    @Override
    public Observable<Boolean> insert(FormEntity formEntity) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().insert(formEntity);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> update(FormEntity formEntity) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().update(formEntity);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> delete(FormEntity formEntity) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().delete(formEntity);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> insertAll(List<FormEntity> formEntities) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                mAppDatabase.optionDao().insertAll(formEntities);
                return true;
            }
        });
    }

    @Override
    public Observable<List<FormEntity>> fetchAllReport() {
        return Observable.fromCallable(new Callable<List<FormEntity>>() {
            @Override
            public List<FormEntity> call() throws Exception {
                return mAppDatabase.optionDao().fetchAllReport();
            }
        });
    }
}
