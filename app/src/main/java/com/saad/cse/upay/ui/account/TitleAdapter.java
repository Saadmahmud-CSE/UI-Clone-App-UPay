package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleViewHolder> {

    private final String title;

    public TitleAdapter(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item_title, parent, false);
        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {
        holder.tvTitle.setText(title);
    }

    @Override
    public int getItemCount() {
        return 1; // Only one title item
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvSectionTitle);
        }
    }
}

