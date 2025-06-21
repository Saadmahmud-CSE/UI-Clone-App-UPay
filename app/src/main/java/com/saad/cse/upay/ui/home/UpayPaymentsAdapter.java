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

public class UpayPaymentsAdapter extends RecyclerView.Adapter<UpayPaymentsAdapter.ViewHolder>{
    public UpayPaymentsAdapter(List<Integer> iconUpay, List<String> titleUpay, Context context) {
        this.iconUpay = iconUpay;
        this.titleUpay = titleUpay;
        this.context = context;
    }

    private List<Integer> iconUpay;
    private List<String> titleUpay;
    private Context context;

    @NonNull
    @Override
    public UpayPaymentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_item_upay_payments, parent, false);
        return new UpayPaymentsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iconUpay.setImageResource(iconUpay.get(position));
        holder.titleUpay.setText(titleUpay.get(position));
    }

    @Override
    public int getItemCount() {
        return iconUpay.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iconUpay;
        TextView titleUpay;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iconUpay = itemView.findViewById(R.id.paymentIcon);
            titleUpay = itemView.findViewById(R.id.paymentTitle);
        }
    }
}
