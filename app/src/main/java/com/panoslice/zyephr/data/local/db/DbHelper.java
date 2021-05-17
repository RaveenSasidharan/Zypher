package com.panoslice.zyephr.data.local.db;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.panoslice.zyephr.data.model.db.FormEntity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface DbHelper {

    Observable<Boolean> insert(FormEntity question);

    Observable<Boolean> update(FormEntity formEntity);

    Observable<Boolean> delete(FormEntity formEntity);

    Observable<Boolean> insertAll(List<FormEntity> questions);

    Observable<List<FormEntity>> fetchAllReport();
}
