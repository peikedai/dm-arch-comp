package com.detroitlabs.devicemanager.ui.list;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.detroitlabs.devicemanager.db.Device;
import com.detroitlabs.devicemanager.repo.DeviceRepository;

import java.util.List;

public class DeviceListViewModel extends ViewModel {

    private LiveData<List<Device>> deviceList;

    public DeviceListViewModel(DeviceRepository deviceRepo) {
        deviceList = deviceRepo.getList();
    }

    public LiveData<List<Device>> getDevices() {
        return deviceList;
    }
}
