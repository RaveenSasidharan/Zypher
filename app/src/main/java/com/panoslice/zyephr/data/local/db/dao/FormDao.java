package com.panoslice.zyephr.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.panoslice.zyephr.data.model.db.FormEntity;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface FormDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(FormEntity question);

    @Update
    void update(FormEntity formEntity);

    @Delete
    void delete(FormEntity formEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<FormEntity> questions);

    @Query("SELECT * FROM form_entity")
    List<FormEntity> fetchAllReport();
}
