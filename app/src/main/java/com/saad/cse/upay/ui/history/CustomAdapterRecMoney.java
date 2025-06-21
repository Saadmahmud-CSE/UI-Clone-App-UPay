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

public class CustomAdapterRecMoney extends RecyclerView.Adapter<CustomAdapterRecMoney.ViewHolder>{
    public CustomAdapterRecMoney(Context context, List<Integer> icon, List<String> title, List<String> subTitle, List<String> dateTime, List<String> money, List<String> moneySub, List<Integer> arrow) {
        this.context = context;
        this.icon = icon;
        this.title = title;
        this.subTitle = subTitle;
        this.dateTime = dateTime;
        this.money = money;
        this.moneySub = moneySub;
        this.arrow = arrow;
    }

    private Context context;
    private List<Integer> icon;
    private List<String> title;
    private List<String> subTitle;
    private List<String> dateTime;
    private List<String> money;
    private List<String> moneySub;
    private List<Integer> arrow;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab_received_money, parent, false);
        return new CustomAdapterRecMoney.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.icon.setImageResource(icon.get(position));
        holder.txt1.setText(title.get(position));
        holder.txt2.setText(subTitle.get(position));
        holder.txt3.setText(dateTime.get(position));
        holder.txt4.setText(money.get(position));
        holder.txt5.setText(moneySub.get(position));
        holder.arrow.setImageResource(arrow.get(position));
    }

    @Override
    public int getItemCount() {
        return icon.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon, arrow;
        TextView txt1, txt2, txt3, txt4, txt5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            txt1 = itemView.findViewById(R.id.txt1);
            txt2 = itemView.findViewById(R.id.txt2);
            txt3 = itemView.findViewById(R.id.txt3);
            txt4 = itemView.findViewById(R.id.txt4);
            txt5 = itemView.findViewById(R.id.txt5);
            arrow = itemView.findViewById(R.id.arrow);
        }
    }
}
