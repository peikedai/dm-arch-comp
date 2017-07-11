package com.detroitlabs.devicemanager.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.detroitlabs.devicemanager.db.Device;
import com.detroitlabs.devicemanager.R;

import java.util.List;


public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.ViewHolder> {
    private List<Device> devices;

    @Override
    public DeviceListAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(devices.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public void setData(List<Device> devices) {
        this.devices = devices;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
        }

        public void bind(Device device) {
            name.setText(device.name);
        }
    }
}
