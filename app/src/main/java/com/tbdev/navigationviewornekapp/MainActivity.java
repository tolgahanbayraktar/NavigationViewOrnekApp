package com.tbdev.navigationviewornekapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView mTextViewBaslik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewBaslik = (TextView) findViewById(R.id.tvBaslik);

        /**
         * Tıklamalar ile ilgili listener
         */
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Navigation View Örnek");
        toolbar.setSubtitle("Alt Yazı");


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        String itemName = (String) item.getTitle();
        mTextViewBaslik.setText(itemName);

        switch (item.getItemId()) {
            case R.id.item_android:
                break;

            case R.id.item_blackberry:
                break;
        }

        navigationViewKapat();
        /**
         * Eğer false göndeirirsen selected olmuyor
         */
        return true;
    }

    private void navigationViewKapat() {
        drawerLayout.closeDrawers();
    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            navigationViewKapat();
        } else {
            super.onBackPressed();
        }
    }
}
