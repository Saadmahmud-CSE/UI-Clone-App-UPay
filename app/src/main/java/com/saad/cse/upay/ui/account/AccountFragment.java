package com.saad.cse.upay.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.saad.cse.upay.R;

import java.util.Arrays;
import java.util.List;

public class AccountFragment extends Fragment {

    RecyclerView recycler;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        recycler = v.findViewById(R.id.recyclerAccountMain);

        // Create GridLayoutManager with 2 columns
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recycler.setLayoutManager(layoutManager);

        // Profile section (full span)
        AccountTopAdapter profileAdapter = new AccountTopAdapter(
                R.drawable.people,
                "Mohammad saad udd\nin chowdhury",
                "01877616047",
                "Balance",
                "৳ 0.00"
        );

        // Wallet title section (full span)
        TitleAdapter titleAdapter = new TitleAdapter("Wallets");

        // Wallet items (half span)
        List<String> titles = Arrays.asList("Primary", "Disbursement", "Salary", "Remittance");
        List<String> amounts = Arrays.asList("0.00", "0.00", "0.00", "0.00");
        WalletsAdapter walletsAdapter = new WalletsAdapter(titles, amounts);

        // CashReward Section
        CashRewardAdapter cashRewardAdapter = new CashRewardAdapter(
                R.drawable.ic_cash_reward,
                "Cash Reward",
                "20.00",
                "You can use this reward balance for\nmobile recharge, all kinds of payment &\npay bill."
        );

        // Prepaid Card Section
        PrepaidCardAdapter prepaidCardAdapter = new PrepaidCardAdapter(
                R.drawable.ic_prepaidcard,
                "Prepaid Card",
                "+ Request"
        );

        // Credit Card Section
        CreditCardAdapter creditCardAdapter = new CreditCardAdapter(
                "Linked Credit Cards ",
                "(UCB only)",
                "+ Link"
        );

        // Linked Accounts Section
        LinkedAccountAdapter linkedAccountAdapter = new LinkedAccountAdapter(
                "Linked Accounts ",
                "(UCB only)",
                "+ Link"
        );

        // Limits & Usage Section
        LimitsAdapter limitsAdapter = new LimitsAdapter(
                "Limits & Usage",
                R.drawable.ic_rarrow_blue
        );

        // Service Charge Section
        ServiceAdapter serviceAdapter = new ServiceAdapter(
                "Service Charge",
                R.drawable.ic_rarrow_blue
        );

        // Combine all
        ConcatAdapter concatAdapter = new ConcatAdapter(
                profileAdapter,
                titleAdapter,
                walletsAdapter,
                cashRewardAdapter,
                prepaidCardAdapter,
                creditCardAdapter,
                linkedAccountAdapter,
                limitsAdapter,
                serviceAdapter
        );
        recycler.setAdapter(concatAdapter);

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.wallet_grid_spacing);
        recycler.addItemDecoration(new WalletItemDecoration(spacingInPixels));

        // Handle span sizes
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0 || position == 1) {
                    return 2; // profile and title full span
                }

                // Get adapter count sizes
                int walletsCount = walletsAdapter.getItemCount();

                // Wallets take half span (2 columns)
                if (position >= 2 && position < 2 + walletsCount) {
                    return 1;
                }

                // Everything else (like CashReward) takes full span
                return 2;
            }
        });
    }
}
