package com.microsoft.msftbreweryworkshop.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.microsoft.msftbreweryworkshop.MSFTBreweryApplication;
import com.microsoft.msftbreweryworkshop.R;
import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail;
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse;
import com.microsoft.msftbreweryworkshop.service.BreweryService;
import com.microsoft.msftbreweryworkshop.service.ServiceListener;

public class BreweryDetailFragment extends Fragment implements ServiceListener<DetailResponse<BreweryDetail>> {
    private static String ARG_BREWERY_ID = "BREWERY_ID";
    private BreweryService breweryService = null;
    private String breweryId = null;

    public static BreweryDetailFragment newInstance(String breweryId) {
        Bundle args = new Bundle();
        BreweryDetailFragment fragment = new BreweryDetailFragment();
        args.putString(ARG_BREWERY_ID, breweryId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() != null) {
            MSFTBreweryApplication app = (MSFTBreweryApplication) getActivity().getApplication();
            breweryService = app.provideBreweryService();
        }

        if (getArguments() != null) {
            breweryId = getArguments().getString(ARG_BREWERY_ID);
        }

        if (breweryId == null) {
            throw new IllegalArgumentException("BreweryDetailFragment requires id in arguments");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getActivity() != null) {
            getActivity().setTitle(getString(R.string.brewery));
        }

        loadDetail();

        return inflater.inflate(R.layout.fragment_brewery_detail, container, false);
    }

    @Override
    public void onSuccess(DetailResponse<BreweryDetail> response) {
        // TODO: add connection to UI
    }

    @Override
    public void onFailure(String error) {
        if (getActivity() != null) {
            getActivity().finish();
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        }
    }

    private void loadDetail() {
        if (breweryService != null) {
            breweryService.getBrewery(breweryId, this);
        }
    }
}