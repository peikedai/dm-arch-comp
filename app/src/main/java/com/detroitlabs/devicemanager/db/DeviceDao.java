package com.detroitlabs.devicemanager.db;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DeviceDao {
    @Insert
    void insertAll(Device... devices);

    @Insert
    void insert(Device device);

    @Query("SELECT * FROM device WHERE serialNumber <> :thisSerialNumber")
    LiveData<List<Device>> getAllExceptThis(String thisSerialNumber);

    @Query("SELECT * FROM device WHERE serialNumber = :serialNumber")
    LiveData<Device> getDevice(String serialNumber);

}
