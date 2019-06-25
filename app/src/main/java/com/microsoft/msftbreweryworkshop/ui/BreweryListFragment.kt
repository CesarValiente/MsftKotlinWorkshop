package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.api.model.ListResponse
import com.microsoft.msftbreweryworkshop.api.model.BreweryItem as ApiBrewery
import com.microsoft.msftbreweryworkshop.ext.app
import com.microsoft.msftbreweryworkshop.ext.showToast
import com.microsoft.msftbreweryworkshop.ext.toBrewery
import com.microsoft.msftbreweryworkshop.model.BreweryListItem
import com.microsoft.msftbreweryworkshop.model.enums.DetailPageType
import com.microsoft.msftbreweryworkshop.service.BreweryService
import com.microsoft.msftbreweryworkshop.service.ServiceListener

class BreweryListFragment : Fragment(), ListItemHandler<BreweryListItem>,
    ServiceListener<ListResponse<ApiBrewery>> {
    private val listAdapter by lazy { BreweryListAdapter(context!!, this) }

    private lateinit var recyclerView: RecyclerView
    private val breweryService: BreweryService? by lazy { activity?.app?.provideBreweryService() }

    companion object {
        fun newInstance() = BreweryListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_brewery_list, container, false)
        setupRecyclerView(view)
        loadData()
        return view
    }

    override fun onItemClick(item: BreweryListItem) {
        context?.let { context ->
            DetailActivity.start(context, DetailPageType.BREWERY_DETAIL, item.id)
        }
    }

    override fun onSuccess(response: ListResponse<ApiBrewery>) {
        listAdapter.items = response.data.map {
            it.toBrewery()
        }
        listAdapter.notifyDataSetChanged()
    }

    override fun onFailure(error: String) {
        listAdapter.items = emptyList()
        showToast(error)
    }

    private fun loadData() {
        //TODO: add loading spinner
        breweryService?.getBreweries(this)
    }

    private fun setupRecyclerView(view: View) {
        recyclerView = view.findViewById<RecyclerView>(R.id.breweries).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = listAdapter
        }
    }
}
