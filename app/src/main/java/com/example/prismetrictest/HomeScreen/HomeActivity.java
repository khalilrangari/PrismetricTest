package com.example.prismetrictest.HomeScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prismetrictest.HomeScreen.Adapter.CategoryAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.DealsAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.HomeViewPagerAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.PagerAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.TrendingAdapter;
import com.example.prismetrictest.HomeScreen.model.CategoryModel;
import com.example.prismetrictest.HomeScreen.model.TrendingModel;
import com.example.prismetrictest.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

  @BindView(R.id.tabBottom)
  TabLayout tabBottom;
  @BindView(R.id.mainViewPager)
  ViewPager mainViewPager;
  @BindView(R.id.toolBar)
  Toolbar topAppBar;
  @BindView(R.id.drawerLayout)
  DrawerLayout drawerLayout;
  @BindView(R.id.navigationView)
  NavigationView navigationView;

  private static final float END_SCALE = 0.7f;

  private PagerAdapter pagerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    ButterKnife.bind(this);

    setSupportActionBar(topAppBar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
      @Override
      public void onDrawerOpened(View drawerView) {
      }

      @Override
      public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
      }
    };
    drawerLayout.addDrawerListener(toggle);

    navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
      @Override
      public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
      }
    });

    setUpBottomTabView();
  }

  @OnClick({R.id.ivMenu})
  public void OnClick(View view){
    switch (view.getId()){
      case R.id.ivMenu:
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
          drawerLayout.closeDrawer(GravityCompat.START);
        } else {
          drawerLayout.openDrawer(GravityCompat.START);
        }
        break;
    }
  }

  //this method is use to setup bottom tab
  private void setUpBottomTabView() {
    tabBottom.addTab(tabBottom.newTab().setIcon(R.drawable.home));
    tabBottom.addTab(tabBottom.newTab().setIcon(R.drawable.search));
    tabBottom.addTab(tabBottom.newTab().setIcon(R.drawable.my_order));
    tabBottom.addTab(tabBottom.newTab().setIcon(R.drawable.notification));
    tabBottom.addTab(tabBottom.newTab().setIcon(R.drawable.profile));
    tabBottom.setTabGravity(TabLayout.GRAVITY_FILL);

    Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
    Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
    Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
    Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
    Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);

    pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabBottom.getTabCount());
    mainViewPager.setAdapter(pagerAdapter);
    tabBottom.setOnTabSelectedListener(this);

    mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        updateBottomTabView(position);
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  // use this method for update bottom tab view while clicked
  private void updateBottomTabView(int position) {
    switch (position) {
      case 0:
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);

        break;
      case 1:
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        break;
      case 2:
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        break;
      case 3:
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        break;
      case 4:
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(0)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(1)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(2)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(3)).getIcon()).setColorFilter(Color.parseColor("#a09c9c"), PorterDuff.Mode.SRC_IN);
        Objects.requireNonNull(Objects.requireNonNull(tabBottom.getTabAt(4)).getIcon()).setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        break;
    }
  }

  @Override
  public void onTabSelected(TabLayout.Tab tab) {
    mainViewPager.setCurrentItem(tab.getPosition());
    updateBottomTabView(tab.getPosition());
  }

  @Override
  public void onTabUnselected(TabLayout.Tab tab) {

  }

  @Override
  public void onTabReselected(TabLayout.Tab tab) {

  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
      drawerLayout.closeDrawer(GravityCompat.START);
    }
  }
}