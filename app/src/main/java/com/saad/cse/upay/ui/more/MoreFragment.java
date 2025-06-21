package com.saad.cse.upay.ui.more;

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

public class MoreFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_more, container, false);

        // Settings Section Start
        RecyclerView settingsRecycler = root.findViewById(R.id.settingsRecyclerView);
        settingsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        List<Integer> iconsSettings = Arrays.asList(R.drawable.ic_pin, R.drawable.ic_lang, R.drawable.ic_permit);
        List<String> titlesSettings = Arrays.asList("Change PIN", "Change Language", "Change Permissions");
        List<Integer> arrowsSettings = Arrays.asList(R.drawable.ic_right_arrow,R.drawable.ic_right_arrow,R.drawable.ic_right_arrow);

        MoreAdapter adapterSettings = new MoreAdapter(getActivity(),iconsSettings,titlesSettings,arrowsSettings);
        settingsRecycler.setAdapter(adapterSettings);
        // Settings Section End

        // Upay Support Section Start
        RecyclerView upaysRecycler = root.findViewById(R.id.upayRecyclerView);
        upaysRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        List<Integer> iconsUpays = Arrays.asList(R.drawable.ic_support, R.drawable.ic_faq);
        List<String> titlesUpays = Arrays.asList("24/7 Support", "FAQ");
        List<Integer> arrowsUpays = Arrays.asList(R.drawable.ic_right_arrow,R.drawable.ic_right_arrow);

        MoreAdapter adapterUpays = new MoreAdapter(getActivity(),iconsUpays,titlesUpays,arrowsUpays);
        upaysRecycler.setAdapter(adapterUpays);
        // Upay Support Section End

        // Account Section Start
        RecyclerView accountsRecycler = root.findViewById(R.id.accountRecyclerView);
        accountsRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        List<Integer> iconsAccounts = Arrays.asList(R.drawable.ic_info, R.drawable.ic_mnp, R.drawable.ic_upay_chaka, R.drawable.ic_face);
        List<String> titlesAccounts = Arrays.asList("Information Update", "Update MNP Info", "upay Chaka", "Disable Fingerprint/Face ID");
        List<Integer> arrowsAccounts = Arrays.asList(R.drawable.ic_right_arrow,R.drawable.ic_right_arrow,R.drawable.ic_right_arrow,R.drawable.ic_right_arrow);

        MoreAdapter adapterAccounts = new MoreAdapter(getActivity(),iconsAccounts,titlesAccounts,arrowsAccounts);
        accountsRecycler.setAdapter(adapterAccounts);
        // Account Section End

        // Policies Section Start
        RecyclerView policiesRecycler = root.findViewById(R.id.policiesRecyclerView);
        policiesRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        List<Integer> iconsPolicies = Arrays.asList(R.drawable.ic_terms, R.drawable.ic_privacy, R.drawable.ic_app_info);
        List<String> titlesPolicies = Arrays.asList("Terms Of Use", "Privacy Policy", "App Info");
        List<Integer> arrowsPolicies = Arrays.asList(R.drawable.ic_right_arrow,R.drawable.ic_right_arrow,R.drawable.ic_right_arrow);

        MoreAdapter adapterPolicies = new MoreAdapter(getActivity(),iconsPolicies,titlesPolicies,arrowsPolicies);
        policiesRecycler.setAdapter(adapterPolicies);
        // Policies Section End

        // Logout Section Start
        RecyclerView logoutRecycler = root.findViewById(R.id.logoutRecyclerView);
        logoutRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));

        List<Integer> iconLogout = Arrays.asList(R.drawable.ic_logout);
        List<String> titleLogout = Arrays.asList("Log Out");

        LogoutAdapter adapterLogout = new LogoutAdapter(getActivity(),iconLogout,titleLogout);
        logoutRecycler.setAdapter(adapterLogout);
        // Logout Section End

        return root;
    }
}