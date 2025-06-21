package com.saad.cse.upay.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

import java.util.List;

public class TopAdapter extends RecyclerView.Adapter<TopAdapter.ViewHolder>{
    public TopAdapter(Context context, List<Integer> icon, List<String> title) {
        this.context = context;
        this.icon = icon;
        this.title = title;
    }

    private Context context;
    private List<Integer> icon;
    private List<String> title;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_top, parent, false);
        return new TopAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(icon.get(position));
        holder.title.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        return icon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.topIcon);
            title = itemView.findViewById(R.id.topTitle);
        }
    }
}
