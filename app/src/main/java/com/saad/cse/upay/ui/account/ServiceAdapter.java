package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{
    public ServiceAdapter(String title, int arrow) {
        this.title = title;
        this.arrow = arrow;
    }

    private final String title;
    private final int arrow;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_service, parent, false);
        return new ServiceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(title);
        holder.arrow.setImageResource(arrow);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView arrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.serviceTitle);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}

