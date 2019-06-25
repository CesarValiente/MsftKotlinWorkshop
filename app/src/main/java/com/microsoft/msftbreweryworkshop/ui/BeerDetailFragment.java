package com.microsoft.msftbreweryworkshop.ui;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class BeerDetailFragment extends Fragment {
    private static String ARG_BEER_ID = "beerId";

    public static BeerDetailFragment newInstance(String beerId) {
        Bundle args = new Bundle();
        BeerDetailFragment fragment = new BeerDetailFragment();
        args.putString(ARG_BEER_ID, beerId);
        fragment.setArguments(args);
        return fragment;
    }
}