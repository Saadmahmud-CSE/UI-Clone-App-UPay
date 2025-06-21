package com.saad.cse.upay.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {
    public BannerAdapter(Context context, List<Integer> image) {
        this.context = context;
        this.image = image;
    }

    private Context context;
    private List<Integer> image;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_banner, parent, false);
        return new BannerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(image.get(position));
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.bannerImage);
        }
    }
}
