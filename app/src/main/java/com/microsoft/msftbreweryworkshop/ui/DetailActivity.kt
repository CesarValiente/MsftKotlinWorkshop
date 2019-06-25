package com.microsoft.msftbreweryworkshop.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.model.enums.DetailPageType
import kotlinx.android.synthetic.main.activity_detail.*
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.msftbreweryworkshop.ext.replaceFragment


class DetailActivity : AppCompatActivity() {
    private val fragmentType by lazy { intent.getSerializableExtra(EXTRA_FRAGMENT_TYPE) as DetailPageType }
    private val detailId by lazy { intent.getStringExtra(EXTRA_DETAIL_ID) }

    companion object {
        const val EXTRA_DETAIL_ID = "detailId"
        const val EXTRA_FRAGMENT_TYPE = "fragmentType"

        fun start(context: Context, type: DetailPageType, detailId: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_FRAGMENT_TYPE, type)
            intent.putExtra(EXTRA_DETAIL_ID, detailId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupFragments()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupFragments() {
        setupToolbar()

        val fragment: Fragment = when(fragmentType) {
            DetailPageType.BEER_DETAIL -> BeerDetailFragment.newInstance(detailId)
            DetailPageType.BREWERY_DETAIL -> BreweryDetailFragment.newInstance(detailId)
        }

        replaceFragment(R.id.fragment_container, fragment, "detail")
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.title = title
    }
}

