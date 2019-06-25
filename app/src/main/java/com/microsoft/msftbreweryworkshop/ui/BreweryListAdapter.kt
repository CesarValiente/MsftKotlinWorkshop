package com.microsoft.msftbreweryworkshop.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.model.BreweryListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_brewery.view.*

class BreweryListAdapter(
    context: Context,
    private val handler: ListItemHandler<BreweryListItem>
) : RecyclerView.Adapter<BreweryListAdapter.BreweryHolder>() {
    var items: List<BreweryListItem> = emptyList()
    private val layoutInflater by lazy {LayoutInflater.from(context)}

    class BreweryHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout: ConstraintLayout = view.brewery_content
        val name: TextView = view.brewery_name
        val established: TextView = view.brewery_established
        val active: TextView = view.brewery_active
        val icon: ImageView = view.brewery_icon
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BreweryHolder {
        val layout = layoutInflater.inflate(R.layout.item_brewery, parent, false)
        return BreweryHolder(layout)
    }

    override fun onBindViewHolder(holder: BreweryHolder, position: Int) {
        with(items[position]) {

            holder.name.text = name
            holder.established.text = established
            holder.active.visibility = if (isActive) View.VISIBLE else View.GONE

            icon?.let {
                Picasso.get()
                    .load(it)
                    .placeholder(R.mipmap.ic_launcher)
                    .resize(80, 80)
                    .onlyScaleDown()
                    .into(holder.icon)
            }

            holder.layout.setOnClickListener {
                handler.onItemClick(this)
            }
        }
    }

    override fun getItemCount() = items.size
}