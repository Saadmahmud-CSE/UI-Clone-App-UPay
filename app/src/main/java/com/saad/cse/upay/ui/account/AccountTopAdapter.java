package com.saad.cse.upay.ui.account;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class AccountTopAdapter extends RecyclerView.Adapter<AccountTopAdapter.Holder> {

    private final int icon;
    private final String name, phone, totalBalance, balance;

    public AccountTopAdapter(int icon, String name, String phone, String totalBalance, String balance) {
        this.icon = icon;
        this.name = name;
        this.phone = phone;
        this.totalBalance = totalBalance;
        this.balance = balance;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.account_item_top, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder h, int position) {
        h.icon.setImageResource(icon);
        h.name.setText(name);
        h.phone.setText(phone);
        h.totalBal.setText(totalBalance);
        h.balance.setText(balance);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class Holder extends RecyclerView.ViewHolder {
        CircleImageView icon;
        TextView name, phone, totalBal, balance;
        public Holder(View v) {
            super(v);
            icon = v.findViewById(R.id.circleImageView);
            name = v.findViewById(R.id.textView);
            phone = v.findViewById(R.id.textView2);
            totalBal = v.findViewById(R.id.textView3);
            balance = v.findViewById(R.id.textView4);
        }
    }
}
