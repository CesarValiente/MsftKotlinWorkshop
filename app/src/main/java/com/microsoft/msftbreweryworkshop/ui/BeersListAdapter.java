package com.microsoft.msftbreweryworkshop.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.microsoft.msftbreweryworkshop.model.BeerListItem;

public class BeersListAdapter extends RecyclerView.Adapter<BeersListAdapter.BeerHolder> {
    Context context;
    ListItemHandler<BeerListItem> handler;

    public BeersListAdapter(Context context, ListItemHandler<BeerListItem> handler) {
        this.context = context;
        this.handler = handler;
    }

    @NonNull
    @Override
    public BeerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BeerHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class BeerHolder extends RecyclerView.ViewHolder {
        public BeerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}