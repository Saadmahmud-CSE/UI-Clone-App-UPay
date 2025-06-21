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

public class MoreAdapter extends RecyclerView.Adapter<MoreAdapter.ViewHolder>{
    public MoreAdapter(Context context, List<Integer> iconResId, List<String> title, List<Integer> iconArrow) {
        this.context = context;
        this.iconResId = iconResId;
        this.title = title;
        this.iconArrow = iconArrow;
    }

    private Context context;
    private List<Integer> iconResId;
    private List<String> title;
    private List<Integer> iconArrow;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_more_row_card, parent, false);
        return new MoreAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(iconResId.get(position));
        holder.title.setText(title.get(position));
        holder.arrow.setImageResource(iconArrow.get(position));
    }

    @Override
    public int getItemCount() {
        return iconResId.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon, arrow;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            title = itemView.findViewById(R.id.title);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}
