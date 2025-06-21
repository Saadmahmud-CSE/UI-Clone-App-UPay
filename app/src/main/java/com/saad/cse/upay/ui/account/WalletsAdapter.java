package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

import java.util.List;

public class WalletsAdapter extends RecyclerView.Adapter<WalletsAdapter.Holder> {

    private final List<String> titles;
    private final List<String> amounts;

    public WalletsAdapter(List<String> titles, List<String> amounts) {
        this.titles = titles;
        this.amounts = amounts;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_wallet, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.tvTitle.setText(titles.get(position));
        holder.tvAmount.setText("৳ " + amounts.get(position));
        switch (position) {
            case 0:
                holder.itemView.setBackgroundResource(R.drawable.bg_wallet_primary);
                break;
            case 1:
                holder.itemView.setBackgroundResource(R.drawable.bg_wallet_dis);
                break;
            case 2:
                holder.itemView.setBackgroundResource(R.drawable.bg_wallet_salary);
                break;
            case 3:
                holder.itemView.setBackgroundResource(R.drawable.bg_wallet_rem);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvAmount;

        public Holder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvWalletTitle);
            tvAmount = itemView.findViewById(R.id.tvWalletAmount);
        }
    }
}
