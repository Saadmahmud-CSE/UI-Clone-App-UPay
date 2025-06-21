package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

public class CreditCardAdapter extends RecyclerView.Adapter<CreditCardAdapter.ViewHolder>{
    public CreditCardAdapter(String title, String subTitle, String link) {
        this.title = title;
        this.subTitle = subTitle;
        this.link = link;
    }

    private final String title;
    private final String subTitle;
    private final String link;

    @NonNull
    @Override
    public CreditCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item_credit, parent, false);
        return new CreditCardAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditCardAdapter.ViewHolder holder, int position) {
        holder.title.setText(title);
        holder.sub.setText(subTitle);
        holder.link.setText(link);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, sub, link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.creditTitle);
            sub = itemView.findViewById(R.id.creditSub);
            link = itemView.findViewById(R.id.link);
        }
    }
}
