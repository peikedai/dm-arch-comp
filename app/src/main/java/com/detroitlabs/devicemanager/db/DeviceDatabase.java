package com.detroitlabs.devicemanager.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Device.class}, version = 1)
public abstract class DeviceDatabase extends RoomDatabase {
    public abstract DeviceDao deviceDao();
}
