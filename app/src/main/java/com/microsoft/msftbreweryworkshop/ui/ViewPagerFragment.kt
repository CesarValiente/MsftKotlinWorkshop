package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.microsoft.msftbreweryworkshop.R

class ViewPagerFragment : Fragment() {

    private lateinit var contentAdapter: ContentAdapter
    private lateinit var viewPager: ViewPager

    companion object {
        fun newInstance() = ViewPagerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.view_pager_layout, container, false)
        setupAdapter(view)
        return view
    }

    private fun setupAdapter(view: View) {
        contentAdapter = ContentAdapter(childFragmentManager)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = contentAdapter

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
}

private class ContentAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val TABS_COUNT = 2
    private val TAB_BEERS = 0
    private val TAB_BREWERY = 1

    override fun getCount() = TABS_COUNT

    override fun getItem(position: Int): Fragment =
        when (position) {
            TAB_BEERS -> BeerListFragment.newInstance()
            TAB_BREWERY -> BreweryListFragment.newInstance()
            else -> throw IllegalArgumentException("Wrong $position for ContentAdapter")
        }

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        TAB_BEERS -> "Beers"
        TAB_BREWERY -> "Breweries"
        else -> null
    }
}