package com.microsoft.msftbreweryworkshop.ui;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.msftbreweryworkshop.R;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setupFragments();
    }

    private void replaceFragment(int fragmentContainerId, Fragment fragment, String fragmentName, Boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(fragmentContainerId, fragment);

        if (addToBackStack) {
            transaction.addToBackStack(fragmentName);
        }

        transaction.commit();
    }

    private void setupFragments() {
        setupToolbar();
        setupViewPager();
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }

    private void setupViewPager() {
        Fragment fragment = ViewPagerFragment.newInstance();
        replaceFragment(R.id.fragment_container, fragment, "viewPager", false);
    }
}

