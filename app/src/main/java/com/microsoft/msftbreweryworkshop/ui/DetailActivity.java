package com.microsoft.msftbreweryworkshop.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.microsoft.msftbreweryworkshop.R;
import com.microsoft.msftbreweryworkshop.model.enums.DetailPageType;


public class DetailActivity extends AppCompatActivity {
    private static String EXTRA_DETAIL_ID = "detailId";
    private static String EXTRA_FRAGMENT_TYPE = "fragmentType";
    private DetailPageType fragmentType = null;
    private String detailId = null;

    static void start(Context context, DetailPageType type, String detailId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTRA_FRAGMENT_TYPE, type);
        intent.putExtra(EXTRA_DETAIL_ID, detailId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        fragmentType = (DetailPageType) intent.getSerializableExtra(EXTRA_FRAGMENT_TYPE);
        detailId = intent.getStringExtra(EXTRA_DETAIL_ID);

        setupFragments();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupFragments() {
        setupToolbar();
        Fragment fragment = null;
        switch(fragmentType) {
            case BEER_DETAIL:
                fragment = BeerDetailFragment.newInstance(detailId);
                break;
            case BREWERY_DETAIL:
                fragment = BreweryDetailFragment.newInstance(detailId);
                break;
        }

        replaceFragment(R.id.fragment_container, fragment, "detail", false);
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

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
    }
}

