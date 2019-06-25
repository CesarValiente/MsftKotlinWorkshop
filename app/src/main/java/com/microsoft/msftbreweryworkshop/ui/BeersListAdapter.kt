package com.microsoft.msftbreweryworkshop.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.model.BeerListItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_beer.view.*
import org.w3c.dom.Text

class BeersListAdapter(
    context: Context,
    private val handler: ListItemHandler<BeerListItem>
) : RecyclerView.Adapter<BeersListAdapter.BeerHolder>() {
    var items: List<BeerListItem> = emptyList()
    private val layoutInflater by lazy {LayoutInflater.from(context)}

    class BeerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val layout: ConstraintLayout = view.beer_content
        val name: TextView = view.beer_name
        val image: ImageView = view.beer_icon
        val organic: TextView = view.beer_ogranic
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeerHolder {
        val layout = layoutInflater.inflate(R.layout.item_beer, parent, false)
        return BeerHolder(layout)
    }

    override fun onBindViewHolder(holder: BeerHolder, position: Int) {
        with(items[position]) {
            holder.name.text = name
            val image = icon
            image?.let {
                Picasso.get()
                    .load(it)
                    .placeholder(R.mipmap.ic_launcher)
                    .resize(80, 80)
                    .onlyScaleDown()
                    .into(holder.image)
            }
            holder.organic.visibility = if (isOrganic) View.VISIBLE else View.GONE
            holder.layout.setOnClickListener {
                handler.onItemClick(this)
            }
        }
    }

    override fun getItemCount() = items.size
}