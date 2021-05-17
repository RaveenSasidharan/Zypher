package com.panoslice.zyephr.data.local.db;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.panoslice.zyephr.data.local.db.dao.FormDao;
import com.panoslice.zyephr.data.model.db.FormEntity;


@Database(entities = {FormEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FormDao optionDao();
}
