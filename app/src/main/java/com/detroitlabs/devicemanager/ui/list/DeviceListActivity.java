package com.detroitlabs.devicemanager.ui.list;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.detroitlabs.devicemanager.R;
import com.detroitlabs.devicemanager.databinding.ActivityDeviceListBinding;
import com.detroitlabs.devicemanager.db.Device;

import java.util.List;

public class DeviceListActivity extends LifecycleActivity {

    private ActivityDeviceListBinding binding;
    private DeviceListAdapter deviceListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_device_list);

        binding.list.setLayoutManager(new LinearLayoutManager(this));
        deviceListAdapter = new DeviceListAdapter();
        binding.list.setAdapter(deviceListAdapter);

        DeviceListViewModel viewModel = ViewModelProviders.of(this).get(DeviceListViewModel.class);
        viewModel.getDevices().observe(this, new Observer<List<Device>>() {
            @Override
            public void onChanged(@Nullable List<Device> devices) {
                deviceListAdapter.setData(devices);
            }
        });
    }
}
