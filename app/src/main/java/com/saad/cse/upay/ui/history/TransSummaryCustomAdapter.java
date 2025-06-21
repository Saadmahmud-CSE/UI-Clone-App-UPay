package com.saad.cse.upay.ui.history;

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

public class TransSummaryCustomAdapter extends RecyclerView.Adapter<TransSummaryCustomAdapter.ViewHolder>{
    public TransSummaryCustomAdapter(Context context, List<Integer> icon, List<String> title, List<String> money) {
        this.context = context;
        this.icon = icon;
        this.title = title;
        this.money = money;
    }

    private Context context;
    private List<Integer> icon;
    private List<String> title;
    private List<String> money;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab2_summary, parent, false);
        return new TransSummaryCustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(icon.get(position));
        holder.title.setText(title.get(position));
        holder.money.setText(money.get(position));
    }

    @Override
    public int getItemCount() {
        return icon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView title, money;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.iconSummary);
            title = itemView.findViewById(R.id.titleSummary);
            money = itemView.findViewById(R.id.moneySummary);
        }
    }
}
