package com.saad.cse.upay.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.saad.cse.upay.R;

public class HistoryFragment extends Fragment {
    private TabLayout mainTabLayout;
    private ViewPager2 mainViewPager;
    private final String[] tabTitles1 = {"Transaction Details", "Transaction\nSummary"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        mainTabLayout = view.findViewById(R.id.mainTabLayout);
        mainViewPager = view.findViewById(R.id.mainViewPager);

        MainViewPagerAdapter adapter = new MainViewPagerAdapter(requireActivity());
        mainViewPager.setAdapter(adapter);

        // Attach TabLayoutMediator and set custom views
        new TabLayoutMediator(mainTabLayout, mainViewPager, (tab, position) -> {
            View customTab = LayoutInflater.from(getContext()).inflate(R.layout.custom_tab, null);
            TextView tabText = customTab.findViewById(R.id.tab_text);
            tabText.setText(tabTitles1[position]);

            // Initial style: first tab = selected, others = unselected
            if (position == 0) {
                customTab.setBackgroundResource(R.drawable.tab_selected);
                tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
            } else {
                customTab.setBackgroundResource(R.drawable.tab_unselected);
                tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
            }

            tab.setCustomView(customTab);
        }).attach();

        // Handle tab selection to update styling
        mainTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextView tabText = customView.findViewById(R.id.tab_text);
                    customView.setBackgroundResource(R.drawable.tab_selected);
                    tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextView tabText = customView.findViewById(R.id.tab_text);
                    customView.setBackgroundResource(R.drawable.tab_unselected);
                    tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }
}
