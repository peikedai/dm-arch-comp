package com.detroitlabs.devicemanager.repo;


import android.arch.lifecycle.LiveData;

import com.detroitlabs.devicemanager.db.Device;

import java.util.List;

public interface DeviceSource {
    LiveData<List<Device>> fetchAll();
}
