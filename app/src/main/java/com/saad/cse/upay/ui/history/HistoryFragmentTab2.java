package com.saad.cse.upay.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.saad.cse.upay.R;

import java.util.Arrays;
import java.util.List;

public class HistoryFragmentTab2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_tab2, container, false);

        RecyclerView summaryList = view.findViewById(R.id.listSummary);
        summaryList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Integer> icons = Arrays.asList(
                R.drawable.ic_cash_in, R.drawable.ic_addmoney, R.drawable.ic_received_money,
                R.drawable.ic_remittance, R.drawable.ic_salary, R.drawable.ic_disbursement,
                R.drawable.ic_cash_reward, R.drawable.ic_cashout, R.drawable.ic_send_money,
                R.drawable.ic_mobile, R.drawable.ic_payment, R.drawable.ic_paybill, R.drawable.ic_fund
        );

        List<String> titles = Arrays.asList(
                "Cash In", "Add Money", "Received Money",
                "Remittance", "Salary", "Disbursement",
                "Cash Reward", "Cash Out", "Send Money",
                "Mobile Recharge", "Make Payment", "Pay Bill",
                "Fund Transfer"
        );

        List<String> money = Arrays.asList(
                "৳ 0.00", "৳ 0.00", "৳ 0.00",
                "৳ 0.00", "৳ 0.00", "৳ 0.00",
                "৳ 20.00", "৳ 0.00", "৳ 0.00",
                "৳ 0.00", "৳ 0.00", "৳ 0.00","৳ 0.00"
        );

        TransSummaryCustomAdapter adapter = new TransSummaryCustomAdapter(getContext(), icons, titles, money);
        summaryList.setAdapter(adapter);

        return view;
    }
}
