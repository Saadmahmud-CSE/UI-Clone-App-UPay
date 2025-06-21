package com.saad.cse.upay.ui.more;

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

public class LogoutAdapter extends RecyclerView.Adapter<LogoutAdapter.ViewHolder>{
    public LogoutAdapter(Context context, List<Integer> iconResId, List<String> title) {
        this.context = context;
        this.iconResId = iconResId;
        this.title = title;
    }
    private Context context;
    private List<Integer> iconResId;
    private List<String> title;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_more_logout, parent, false);
        return new LogoutAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(iconResId.get(position));
        holder.title.setText(title.get(position));
    }

    @Override
    public int getItemCount() {
        return title.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
        }
    }
}
