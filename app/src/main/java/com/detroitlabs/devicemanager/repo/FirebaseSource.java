package com.detroitlabs.devicemanager.repo;

import android.arch.lifecycle.LiveData;

import com.detroitlabs.devicemanager.db.Device;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class FirebaseSource implements DeviceSource {
    @Override
    public LiveData<List<Device>> fetchAll() {
        FirebaseDatabase.getInstance().getReference()
                .child("devices").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return null;
    }
}
