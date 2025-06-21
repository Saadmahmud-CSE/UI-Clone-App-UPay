package com.saad.cse.upay.ui.history;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class HistoryPagerTab1 extends FragmentStateAdapter {
    public HistoryPagerTab1(@NonNull Fragment fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return new HistoryFragmentAll();
            case 1: return new HistoryFragmentSendMoney();
            case 2: return new HistoryFragmentReceivedMoney();
            case 3: return new HistoryFragmentMobileRecharge();
            case 4: return new HistoryFragmentPayBill();
            case 5: return new HistoryFragmentCashIn();
            case 6: return new HistoryFragmentCashOut();
            case 7: return new HistoryFragmentFundTransfer();
            case 8: return new HistoryFragmentAddMoney();
            case 9: return new HistoryFragmentMakePayment();
            case 10: return new HistoryFragmentPrepaidCard();
            default: return new HistoryFragmentAll(); // fallback
        }
    }

    @Override
    public int getItemCount() {
        return 11;
    }
}
