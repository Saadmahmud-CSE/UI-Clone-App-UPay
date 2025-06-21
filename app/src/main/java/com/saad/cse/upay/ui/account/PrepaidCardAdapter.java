package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

public class PrepaidCardAdapter extends RecyclerView.Adapter<PrepaidCardAdapter.ViewHolder>{
    public PrepaidCardAdapter(int iconRes, String title, String req) {
        this.iconRes = iconRes;
        this.title = title;
        this.req = req;
    }

    private final int iconRes;
    private final String title;
    private final String req;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_prepaid, parent, false);
        return new PrepaidCardAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(iconRes);
        holder.title.setText(title);
        holder.req.setText(req);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title, req;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.preIcon);
            title = itemView.findViewById(R.id.preTitle);
            req = itemView.findViewById(R.id.req);
        }
    }
}
