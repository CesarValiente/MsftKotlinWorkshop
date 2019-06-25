package com.microsoft.msftbreweryworkshop.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.microsoft.msftbreweryworkshop.R;
import com.microsoft.msftbreweryworkshop.model.BreweryListItem;

import java.util.List;

public class BreweryListAdapter extends RecyclerView.Adapter<BreweryListAdapter.BreweryHolder> {
    public List<BreweryListItem> items;
    private Context context;
    private ListItemHandler<BreweryListItem> handler;

    public BreweryListAdapter(Context context, ListItemHandler<BreweryListItem> handler) {
        this.context = context;
        this.handler = handler;
    }

    @NonNull
    @Override
    public BreweryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(context).inflate(R.layout.item_brewery, parent, false);
        return new BreweryHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull BreweryHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class BreweryHolder extends RecyclerView.ViewHolder {
        ConstraintLayout layout;
        TextView name;
        TextView established;
        TextView active;
        ImageView icon;

        public BreweryHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.brewery_content);
            name = itemView.findViewById(R.id.brewery_name);
            established = itemView.findViewById(R.id.brewery_established);
            active = itemView.findViewById(R.id.brewery_active);
            icon = itemView.findViewById(R.id.brewery_icon);
        }
    }
}