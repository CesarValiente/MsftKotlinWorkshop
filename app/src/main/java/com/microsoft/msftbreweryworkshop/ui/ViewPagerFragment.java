package com.microsoft.msftbreweryworkshop.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.microsoft.msftbreweryworkshop.R;

public class ViewPagerFragment extends Fragment {
    private ContentAdapter contentAdapter;
    private ViewPager viewPager;

    static ViewPagerFragment newInstance() {
        return new ViewPagerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_pager_layout, container, false);
        setupAdapter(view);
        return view;
    }

    private void setupAdapter(View view) {
        contentAdapter = new ContentAdapter(getChildFragmentManager());
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(contentAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    class ContentAdapter extends FragmentStatePagerAdapter {
        private final int TABS_COUNT = 2;
        private final int TAB_BEERS = 1;
        private final int TAB_BREWERY = 0;

        public ContentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return TABS_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment;
            switch (position) {
                case TAB_BEERS:
                    fragment = BeerListFragment.newInstance();
                    break;
                case TAB_BREWERY:
                    fragment = BreweryListFragment.newInstance();
                    break;
                default:
                    throw new IllegalArgumentException("Wrong $position for ContentAdapter");
            }

            return fragment;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title;
            switch (position) {
                case TAB_BEERS:
                    title = "Beers";
                    break;
                case TAB_BREWERY:
                    title = "Breweries";
                    break;
                default:
                    title = null;
                    break;

            }

            return title;
        }
    }
}