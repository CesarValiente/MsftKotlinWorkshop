package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.api.model.DetailResponse
import com.microsoft.msftbreweryworkshop.ext.app
import com.microsoft.msftbreweryworkshop.ext.showToast
import com.microsoft.msftbreweryworkshop.ext.toBrewery
import com.microsoft.msftbreweryworkshop.service.BreweryService
import com.microsoft.msftbreweryworkshop.service.ServiceListener
import kotlinx.android.synthetic.main.fragment_brewery_detail.*
import com.microsoft.msftbreweryworkshop.api.model.BreweryDetail
import com.microsoft.msftbreweryworkshop.model.Brewery
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_beer_detail.*
import kotlinx.android.synthetic.main.fragment_brewery_detail.image_medium
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BreweryDetailFragment : Fragment() {
    private val breweryService: BreweryService? by lazy { activity?.app?.provideBreweryService() }

    private val breweryId: String
        get() = arguments?.getString(ARG_BREWERY_ID)
            ?: throw IllegalArgumentException("BreweryDetailFragment requires shipmentId in arguments")

    companion object {
        const val ARG_BREWERY_ID = "BREWERY_ID"

        fun newInstance(breweryId: String) = BreweryDetailFragment().also {
            it.arguments = bundleOf(
                ARG_BREWERY_ID to breweryId
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        activity?.title = getString(R.string.brewery)

        loadDetail()

        return inflater.inflate(R.layout.fragment_brewery_detail, container, false)
    }

    private fun onSuccess(model: Brewery) {
        activity?.title = model.name

        brewery_name.text = String.format(resources.getString(R.string.brewery_detail_name), model.name)
        brewery_description.text =
            String.format(resources.getString(R.string.brewery_detail_description), model.description)
        brewery_organic.text = String.format(
            resources.getString(R.string.brewery_detail_organic),
            if (model.isOrganic) "yes" else "not"
        )
        brewery_status.text = String.format(resources.getString(R.string.brewery_detail_status), model.status)
        brewery_create_date.text =
            String.format(resources.getString(R.string.brewery_detail_create_date), model.createDate)

        Picasso.get()
            .load(model.imageMedium)
            .resize(300, 300)
            .onlyScaleDown()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(image_medium)
    }

    private fun onFailure(error: String) {
        activity?.finish()
        showToast(error)
    }

    private fun loadDetail() {
        CoroutineScope(Dispatchers.Default).launch {
            val response = breweryService?.getBrewery(breweryId)?.await()

            withContext(Dispatchers.Main) {
                if (response != null) {
                    onSuccess(response)
                } else {
                    onFailure("Detail not found")
                }
            }
        }
    }
}