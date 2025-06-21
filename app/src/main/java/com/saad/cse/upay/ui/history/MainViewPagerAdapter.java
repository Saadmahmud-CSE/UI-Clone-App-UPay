package com.saad.cse.upay.ui.history;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MainViewPagerAdapter extends FragmentStateAdapter {
    public MainViewPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (position == 0) ? new HistoryFragmentTab1() : new HistoryFragmentTab2();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
