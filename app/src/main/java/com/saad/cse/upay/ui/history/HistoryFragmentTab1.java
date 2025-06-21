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

public class HistoryFragmentTab1 extends Fragment {
    private final String[] tabTitles2 = {
            "All", "Send Money", "Received Money", "Mobile Recharge", "Pay Bill",
            "Cash In", "Cash Out", "Fund Transfer", "Add Money", "Make Payment", "Prepaid Card"
    };
    private ViewPager2 viewPager;
    private TabLayout tabLayout2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history_tab1, container, false);

        viewPager = view.findViewById(R.id.pager);
        tabLayout2 = view.findViewById(R.id.tab1);

        // Adapter for ViewPager
        viewPager.setAdapter(new HistoryPagerTab1(this));

        // Setup with TabLayoutMediator and custom tab views
        new TabLayoutMediator(tabLayout2, viewPager, (tab, position) -> {
            View customTab = LayoutInflater.from(getContext()).inflate(R.layout.custom_tab2, null);
            TextView tabText = customTab.findViewById(R.id.tab_text2);
            tabText.setText(tabTitles2[position]);

            // First tab: selected style
            if (position == 0) {
                customTab.setBackgroundResource(R.drawable.tab_selected2);
                tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
            } else {
                customTab.setBackgroundResource(R.drawable.tab_unselected2);
                tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray));
            }

            tab.setCustomView(customTab);
        }).attach();

        // Handle tab selection styling
        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextView tabText = customView.findViewById(R.id.tab_text2);
                    customView.setBackgroundResource(R.drawable.tab_selected2);
                    tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.black));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View customView = tab.getCustomView();
                if (customView != null) {
                    TextView tabText = customView.findViewById(R.id.tab_text2);
                    customView.setBackgroundResource(R.drawable.tab_unselected2);
                    tabText.setTextColor(ContextCompat.getColor(requireContext(), R.color.gray));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        return view;
    }
}
