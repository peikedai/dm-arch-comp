package com.detroitlabs.devicemanager.ui.list;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.detroitlabs.devicemanager.db.Device;
import com.detroitlabs.devicemanager.repo.DeviceRepository;
import com.detroitlabs.devicemanager.repo.DeviceSource;

import java.util.List;

public class DeviceListViewModel extends AndroidViewModel {

    private LiveData<List<Device>> deviceList;
    private DeviceRepository deviceRepo;

    public DeviceListViewModel(Application application) {
        super(application);
        deviceList = deviceRepo.getList();
    }

    public LiveData<List<Device>> getDevices() {
        return deviceList;
    }

    private void loadDevices() {
        deviceList = deviceRepo.getList();

    }
}
