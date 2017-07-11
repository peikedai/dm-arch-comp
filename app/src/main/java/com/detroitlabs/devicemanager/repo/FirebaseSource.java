package com.detroitlabs.devicemanager.repo;

import android.arch.lifecycle.LiveData;

import com.detroitlabs.devicemanager.FirebaseLiveData;
import com.detroitlabs.devicemanager.db.Device;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FirebaseSource implements DeviceSource {
    @Override
    public LiveData<List<Device>> fetchAll() {
        return new FirebaseLiveData();
    }
}
