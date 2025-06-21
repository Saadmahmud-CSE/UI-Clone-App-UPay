package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

public class CashRewardAdapter extends RecyclerView.Adapter<CashRewardAdapter.Holder> {

    private final String title;
    private final String amount;
    private final String description;
    private final int iconRes;

    // Constructor
    public CashRewardAdapter(int iconRes, String title, String amount, String description) {
        this.iconRes = iconRes;
        this.title = title;
        this.amount = amount;
        this.description = description;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_cash, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.rewardIcon.setImageResource(iconRes);
        holder.rewardTitle.setText(title);
        holder.rewardAmount.setText("৳ " + amount);
        holder.rewardDescription.setText(description);
    }

    @Override
    public int getItemCount() {
        return 1; // Single static item
    }

    static class Holder extends RecyclerView.ViewHolder {

        ImageView rewardIcon;
        TextView rewardTitle, rewardAmount, rewardDescription;

        public Holder(@NonNull View itemView) {
            super(itemView);
            rewardIcon = itemView.findViewById(R.id.rewardIcon);
            rewardTitle = itemView.findViewById(R.id.rewardTitle);
            rewardAmount = itemView.findViewById(R.id.textView4);
            rewardDescription = itemView.findViewById(R.id.rewardDescription);
        }
    }
}
