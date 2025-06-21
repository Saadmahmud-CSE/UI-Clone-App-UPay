package com.saad.cse.upay.ui.history;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saad.cse.upay.R;

import java.util.Arrays;
import java.util.List;

public class HistoryFragmentAll extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history_all, container, false);

        RecyclerView recyclerAll = view.findViewById(R.id.recyclerAll);
        recyclerAll.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        List<Integer> icon = Arrays.asList(R.drawable.ic_hist_logo);
        List<String> title = Arrays.asList("Cash\nReward");
        List<String> subTitle = Arrays.asList("cashreward");
        List<String> dateTime = Arrays.asList("06:23 AM, 08 May 2025");
        List<String> money = Arrays.asList("৳20.00");
        List<String> moneySub = Arrays.asList("৳0.00");
        List<Integer> arrow = Arrays.asList(R.drawable.ic_right_arrow);

        CustomAdapterAll adapter = new CustomAdapterAll(getActivity(), icon, title,subTitle,dateTime,money,moneySub,arrow);
        recyclerAll.setAdapter(adapter);
        return view;
    }
}