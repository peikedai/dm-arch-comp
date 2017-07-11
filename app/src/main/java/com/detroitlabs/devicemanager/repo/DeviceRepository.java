package com.detroitlabs.devicemanager.repo;

import android.arch.lifecycle.LiveData;

import com.detroitlabs.devicemanager.db.Device;
import com.detroitlabs.devicemanager.db.DeviceDao;
import com.detroitlabs.devicemanager.util.DeviceUtil;

import java.util.List;

public class DeviceRepository {

    private DeviceDao deviceDao;

    public DeviceRepository(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public LiveData<List<Device>> getList() {
        return deviceDao.getAllExceptThis(DeviceUtil.getSerialNumber());
    }

    public LiveData<Device> getSelf() {
        return deviceDao.getDevice(DeviceUtil.getSerialNumber());
    }

}
