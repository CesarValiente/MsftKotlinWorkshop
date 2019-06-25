package com.microsoft.msftbreweryworkshop.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microsoft.msftbreweryworkshop.MSFTBreweryApplication;
import com.microsoft.msftbreweryworkshop.R;
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem;
import com.microsoft.msftbreweryworkshop.api.model.ListResponse;
import com.microsoft.msftbreweryworkshop.model.BreweryListItem;
import com.microsoft.msftbreweryworkshop.service.BreweryService;
import com.microsoft.msftbreweryworkshop.service.ServiceListener;

import java.util.Collections;

public class BreweryListFragment extends Fragment implements ListItemHandler<BreweryListItem>,
    ServiceListener<ListResponse<BreweryItem>> {
    private BreweryListAdapter listAdapter;
    private RecyclerView recyclerView;
    private BreweryService breweryService;

    static BreweryListFragment newInstance() {
        return new BreweryListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        breweryService = ((MSFTBreweryApplication) getActivity().getApplication()).provideBreweryService();
        listAdapter = new BreweryListAdapter(getContext(), this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brewery_list, container, false);
        setupRecyclerView(view);
        loadData();
        return view;
    }

    @Override
    public void onSuccess(ListResponse<BreweryItem> response) {
//        listAdapter.items = response.getData();
        listAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure(String error) {
        listAdapter.items = Collections.<BreweryListItem>emptyList();
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(BreweryListItem item) {
//        DetailActivity.start(getContext(), DetailPageType.BREWERY_DETAIL, item.getId());
    }

    private void loadData() {
        breweryService.getBreweries(this);
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.breweries);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }
}
