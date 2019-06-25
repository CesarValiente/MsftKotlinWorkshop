package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.api.model.BeerItem as ApiBeer
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import com.microsoft.msftbreweryworkshop.ext.app
import com.microsoft.msftbreweryworkshop.ext.showToast
import com.microsoft.msftbreweryworkshop.ext.toBeer
import com.microsoft.msftbreweryworkshop.model.BeerListItem
import com.microsoft.msftbreweryworkshop.model.enums.DetailPageType
import com.microsoft.msftbreweryworkshop.service.BeerService
import com.microsoft.msftbreweryworkshop.service.ServiceListener
import kotlinx.coroutines.*

class BeerListFragment : Fragment(), ListItemHandler<BeerListItem> {
    private val listAdapter by lazy { BeersListAdapter(context!!, this) }

    private lateinit var recyclerView: RecyclerView
    private val beerService: BeerService? by lazy { activity?.app?.provideBeerService() }

    companion object {
        fun newInstance() = BeerListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_beer_list, container, false)
        setupRecyclerView(view)
        loadData()
        return view
    }

    override fun onItemClick(item: BeerListItem) {
        context?.let { context ->
            DetailActivity.start(context, DetailPageType.BEER_DETAIL, item.id)
        }
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Default).launch {
            val beerList = beerService?.getBeerList()?.await()

            withContext(Dispatchers.Main) {
                listAdapter.items = beerList ?: emptyList()
                listAdapter.notifyDataSetChanged()
            }
        }
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById<RecyclerView>(R.id.beers).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(view.context)
            adapter = listAdapter
        }
    }

}
