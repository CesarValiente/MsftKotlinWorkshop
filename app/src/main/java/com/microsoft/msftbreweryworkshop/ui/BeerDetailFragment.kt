package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.ext.app
import com.microsoft.msftbreweryworkshop.ext.showToast
import com.microsoft.msftbreweryworkshop.model.Beer
import com.microsoft.msftbreweryworkshop.service.BeerService
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_beer_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BeerDetailFragment : Fragment() {
    private val beerService: BeerService? by lazy { activity?.app?.provideBeerService() }

    private val beerId: String
        get() = arguments?.getString(ARG_BEER_ID)
            ?: throw IllegalArgumentException("BeerDetailFragment requires shipmentId in arguments")

    companion object {
        private const val ARG_BEER_ID = "beerId"

        fun newInstance(beerId: String) = BeerDetailFragment().also {
            it.arguments = bundleOf(
                ARG_BEER_ID to beerId
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        activity?.title = getString(R.string.beer)

        return inflater.inflate(R.layout.fragment_beer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadDetail()
    }

    fun onLoadDetail(model: Beer) {

        activity?.title = model.name

        name.text = String.format(resources.getString(R.string.beer_detail_name), model.name)
        if (model.description == null) {
            description.visibility = View.GONE
        } else {
            description.text = String.format(resources.getString(R.string.beer_detail_description), model.description)
        }
        organic.text = String.format(
            resources.getString(R.string.beer_detail_organic),
            if (model.isOrganic) "yes" else "not"
        )

        abv.text = String.format(resources.getString(R.string.beer_detail_abv), model.abv)
        style.text = String.format(resources.getString(R.string.beer_detail_style), model.style)

        if (model.foodPairings == null) {
            food.visibility = View.GONE
        } else {
            food.text = String.format(resources.getString(R.string.beer_detail_food), model.foodPairings)
        }

        status.text = String.format(resources.getString(R.string.beer_detail_status), model.status)

        Picasso.get()
            .load(model.imageMedium)
            .resize(300, 300)
            .onlyScaleDown()
            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)
            .into(image_medium)
    }

    private fun loadDetail() {
        CoroutineScope(Dispatchers.Default).launch {
            val result = beerService?.getBeer(beerId)?.await()

            withContext(Dispatchers.Main) {
                if (result != null) {
                    onLoadDetail(result)
                } else {
                    activity?.finish()
                    showToast("Detail failed to load")
                }
            }
        }
    }
}