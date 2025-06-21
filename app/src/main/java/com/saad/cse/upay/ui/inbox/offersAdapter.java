package com.saad.cse.upay.ui.inbox;

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

public class offersAdapter extends RecyclerView.Adapter<offersAdapter.ViewHolder>{
    public offersAdapter(Context context, List<Integer> icon, List<String> txt, List<String> txtDetails) {
        this.context = context;
        this.icon = icon;
        this.txt = txt;
        this.txtDetails = txtDetails;
    }
    private Context context;
    private List<Integer> icon;
    private List<String> txt;
    private List<String> txtDetails;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.inbox_item_upay_offers, parent, false);
        return new offersAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(icon.get(position));
        holder.txt.setText(txt.get(position));
        holder.txtDetails.setText(txtDetails.get(position));
    }

    @Override
    public int getItemCount() {
        return icon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView txt, txtDetails;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            txt = itemView.findViewById(R.id.txt);
            txtDetails = itemView.findViewById(R.id.txtDetatils);
        }
    }
}
