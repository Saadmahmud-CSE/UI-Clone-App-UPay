package com.saad.cse.upay.ui.inbox;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saad.cse.upay.R;
import com.saad.cse.upay.ui.home.TopAdapter;

import java.util.Arrays;
import java.util.List;

public class InboxFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_inbox, container, false);

        RecyclerView recyclerOffers = root.findViewById(R.id.recyclerUpayOffers);
        recyclerOffers.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));

        List<Integer> icon = Arrays.asList(R.drawable.offers_01, R.drawable.offers_02, R.drawable.offers_03, R.drawable.offers_04, R.drawable.offers_05,
                R.drawable.offers_06, R.drawable.offers_07, R.drawable.offers_08, R.drawable.offers_09, R.drawable.offers_10,
                R.drawable.offers_11, R.drawable.offers_12, R.drawable.offers_13, R.drawable.offers_14, R.drawable.offers_15);
        List<String> txt = Arrays.asList("Withdraw money from Peyoneer to উপায় and enjoy upto Tk 300 Cash...\nReward.",
                "Unlimited Cashback upon\nPurchasing Specific Packs of Bang...\nlalink from upay app or by dialing *268#. This offer is applicable for recharge to both own number and any other number.",
                "Unlimited Cashback upon\nPurchasing Specific Packs of Robi...\n from upay app or by dialing *268#. This offer is applicable for recharge to both own number and any other number.",
                "Unlimited Cashback upon\nPurchasing Specific Packs of Airtel...\n from upay app or by dialing *268#. This offer is applicable for recharge to both own number and any other number.",
                "PAY YOUR UTILITY BILLS EASILY\nWITH উপায়",
                "Unlimited Cashback upon\nPurchasing Specific Packs of Gram....\neenphone from upay app or by dialing *268#. This offer is applicable for recharge to both own number and any other number.",
                "Introducing Banglades's first MFS co-branded Prepaid Card is...\n collaboration with United Commercial Bank PLC.",
                "Enjoy Buy 3 Get 1 on tickets and rides\nat Mana Bay Water Park with...\n Buy 3 Tickets, Get 1 Free offer!",
                "Enjoy Buy 1 Get 3 at Six Season\nHotel with UCB-upay Prepaid Card...",
                "Enjoy 40% Discount On Vehicle Tracking Devices from Finder GP...",
                "Save Up to 50% on Medical\nServices with UCB-upay Prepaid ...\nCard.",
                "Elevate your dining experience with upay Prepaid Card: Up to 15...\n% discount off your bill.",
                "Enjoy upscale shopping with upay Prepaid Card: Up to 25% off at Y...\n Preferred Lifestyle stores with your UCB - উপায় Prepaid Card.",
                "Enjoy up to 25% Discount on Grooming & Salon Services with ...\n your UCB - উপায় Prepaid Card.",
                "Send money to anyone for free, as many times as you like!");
        List<String> txtDetails = Arrays.asList("Tap for details", "Tap for details", "Tap for details","Tap for details","Tap for details",
                "Tap for details","Tap for details","Tap for details","Tap for details","Tap for details","Tap for details","Tap for details",
                "Tap for details","Tap for details","Tap for details");
        offersAdapter adapter = new offersAdapter(getActivity(), icon, txt, txtDetails);
        recyclerOffers.setAdapter(adapter);

        return root;
    }
}