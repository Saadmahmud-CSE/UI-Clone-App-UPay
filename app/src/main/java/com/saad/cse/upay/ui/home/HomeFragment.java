package com.saad.cse.upay.ui.home;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.saad.cse.upay.BalloonIndicatorView;
import com.saad.cse.upay.R;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {
    private Handler bannerHandler = new Handler();
    private Runnable bannerRunnable;
    private ViewPager2 bannerPager;
    private BalloonIndicatorView dotsIndicator;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Top Section Start
        RecyclerView recyclerTop = root.findViewById(R.id.recyclerTop);
        recyclerTop.setLayoutManager(new GridLayoutManager(getContext(), 4));

        List<Integer> iconTop = Arrays.asList(R.drawable.ic_send_money, R.drawable.ic_mobile, R.drawable.ic_cashout, R.drawable.ic_payment,
                R.drawable.ic_paybill, R.drawable.ic_addmoney, R.drawable.ic_reqmoney, R.drawable.ic_fund);
        List<String> titleTop = Arrays.asList("Send Money", "Mobile Recharge", "Cash Out", "Make Payment",
                "Pay Bill", "Add Money", "Request Money", "Fund Transfer");
        TopAdapter adapterTop = new TopAdapter(getActivity(), iconTop, titleTop);
        recyclerTop.setAdapter(adapterTop);
        // Top Section End

        // Banner Section Start
        bannerPager = root.findViewById(R.id.viewPagerBanner);
        List<Integer> bannerList = Arrays.asList(R.drawable.banner1, R.drawable.ic_banner2, R.drawable.ic_banner3,
                R.drawable.ic_banner4, R.drawable.ic_banner5);
        BannerAdapter bannerAdapter = new BannerAdapter(getActivity(), bannerList);
        bannerPager.setAdapter(bannerAdapter);

        dotsIndicator = root.findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(bannerPager);  // Set the ViewPager
        bannerRunnable = new Runnable() {
            @Override
            public void run() {
                int currentItem = bannerPager.getCurrentItem();
                int nextItem = (currentItem + 1) % bannerList.size();
                bannerPager.setCurrentItem(nextItem, true);
                bannerHandler.postDelayed(this, 3000); // Repeat every 3 seconds
            }
        };
        // Banner Section End

        // Upay payments Section End
        RecyclerView recyclerUpayPayments = root.findViewById(R.id.recyclerUpayPayments);
        recyclerUpayPayments.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        List<Integer> icons = Arrays.asList(R.drawable.ic_traffic, R.drawable.ic_toll, R.drawable.ic_govt, R.drawable.ic_edu,
                R.drawable.ic_indianvisa, R.drawable.ic_ngo, R.drawable.ic_insurance, R.drawable.ic_donation,
                R.drawable.ic_zakat, R.drawable.ic_ticket, R.drawable.ic_gp, R.drawable.ic_hotel, R.drawable.ic_app_fee);
        List<String> titles = Arrays.asList("Traffic Fine", "Toll Payment", "Govt. Payment", "Eduction", "Indian Visa",
                "NGO", "Insurance", "Donation", "Zakat\nPayment", "Ticket", "GP Flexiplan", "Hotel", "Application Fee");

        UpayPaymentsAdapter adapter = new UpayPaymentsAdapter(icons, titles, getActivity());
        recyclerUpayPayments.setAdapter(adapter);
        // Upay payments Section End


        // Other Services Section Start
        RecyclerView recyclerOtherServices = root.findViewById(R.id.recyclerOtherServices);
        recyclerOtherServices.setLayoutManager(new GridLayoutManager(getActivity(), 4));

        List<Integer> iconsOther = Arrays.asList(R.drawable.ic_payoneer, R.drawable.ic_refer_earn, R.drawable.ic_chaka, R.drawable.ic_music,
                R.drawable.ic_elearn, R.drawable.ic_games);
        List<String> titlesOther = Arrays.asList("Payoneer", "Refer & Earn", "upay Chaka", "Music",
                "e-learning", "Games");
        OtherServicesAdapter adapterServices = new OtherServicesAdapter(getActivity(),iconsOther,titlesOther);
        recyclerOtherServices.setAdapter(adapterServices);
        // Other Services Section End


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        bannerHandler.postDelayed(bannerRunnable, 3000); // Start auto-scroll
    }

    @Override
    public void onPause() {
        super.onPause();
        bannerHandler.removeCallbacks(bannerRunnable); // Stop auto-scroll
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bannerHandler.removeCallbacks(bannerRunnable); // Ensure handler is cleared
    }
}