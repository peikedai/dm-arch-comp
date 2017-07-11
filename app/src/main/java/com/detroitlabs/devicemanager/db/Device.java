package com.detroitlabs.devicemanager.db;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Device {

    @PrimaryKey
    public String serialNumber;
    public String name;
}
