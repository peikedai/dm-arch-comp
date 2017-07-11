package com.detroitlabs.devicemanager.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.detroitlabs.devicemanager.db.Device;
import com.detroitlabs.devicemanager.db.DeviceDao;
import com.detroitlabs.devicemanager.util.DeviceUtil;

import java.util.List;

public class DeviceRepository {

    private DeviceDao deviceDao;
    private LiveData<List<Device>> fromDb;
    private MediatorLiveData<List<Device>> mediatorLiveData;
    private DeviceSource deviceSource;

    public LiveData<List<Device>> getList() {
        mediatorLiveData.addSource(deviceSource.fetchAll(), new Observer<List<Device>>() {
            @Override
            public void onChanged(List<Device> devices) {
                deviceDao.insertAll(devices.toArray(new Device[devices.size()]));
            }
        });
        return deviceDao.getAllExceptThis(DeviceUtil.getSerialNumber());
    }

}
