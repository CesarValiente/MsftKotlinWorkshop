package com.microsoft.msftbreweryworkshop.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.microsoft.msftbreweryworkshop.R
import com.microsoft.msftbreweryworkshop.ext.replaceFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupFragments()
    }

    fun setupFragments() {
        setupToolbar()
        setupViewPager()
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        toolbar.title = title
    }

    private fun setupViewPager() {
        val fragment = ViewPagerFragment.newInstance()
        replaceFragment(R.id.fragment_container, fragment, "viewPager")
    }
}

