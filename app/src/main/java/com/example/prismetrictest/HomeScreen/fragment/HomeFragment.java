package com.example.prismetrictest.HomeScreen.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.prismetrictest.CategoryDetails.CategoryDetailsActivity;
import com.example.prismetrictest.HomeScreen.Adapter.CategoryAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.DealsAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.HomeViewPagerAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.OnItemClickListener;
import com.example.prismetrictest.HomeScreen.Adapter.PagerAdapter;
import com.example.prismetrictest.HomeScreen.Adapter.TrendingAdapter;
import com.example.prismetrictest.HomeScreen.model.CategoryModel;
import com.example.prismetrictest.HomeScreen.model.TrendingModel;
import com.example.prismetrictest.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment{

  @BindView(R.id.rvCategory)
  RecyclerView rvCategory;
  @BindView(R.id.viewPager)
  ViewPager pager;
  @BindView(R.id.tabLayout)
  TabLayout tabLayout;
  @BindView(R.id.rvTrending)
  RecyclerView rvTrending;
  @BindView(R.id.rvDealsOfDay)
  RecyclerView rvDealsOfDay;
  @BindView(R.id.rvCategories)
  RecyclerView rvCategories;

  CategoryAdapter categoryAdapter;
  TrendingAdapter trendingAdapter;
  DealsAdapter dealsAdapter;
  LinearLayoutManager layoutManager;
  ArrayList<CategoryModel> categoryModelList = new ArrayList<>();
  ArrayList<Integer> photosUrl = new ArrayList<>();
  ArrayList<TrendingModel> trendingModelList = new ArrayList<>();

  private Unbinder unbinder;

  public HomeFragment() {
  }


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    unbinder = ButterKnife.bind(this, view);

    setUpCategoryAdapter();
    setUpCategoiesAdapter();
    setUpViewPagerAndTab();
    setUpTrendingAdapter();
    setUpDealsAdapter();
    return view;
  }

  //this method is use for setup data of categories at last view of the screen
  private void setUpCategoiesAdapter() {
    categoryModelList = new ArrayList<>();

    categoryModelList.add(new CategoryModel(R.drawable.categories_1, getResources().getString(R.string.men)));
    categoryModelList.add(new CategoryModel(R.drawable.categories_2, getResources().getString(R.string.women)));
    categoryModelList.add(new CategoryModel(R.drawable.categories_3, getResources().getString(R.string.kids)));
    categoryModelList.add(new CategoryModel(R.drawable.categories_4, getResources().getString(R.string.beauty)));

    categoryModelList.add(new CategoryModel(R.drawable.men, getResources().getString(R.string.men)));
    categoryModelList.add(new CategoryModel(R.drawable.women, getResources().getString(R.string.women)));
    categoryModelList.add(new CategoryModel(R.drawable.kids, getResources().getString(R.string.kids)));
    categoryModelList.add(new CategoryModel(R.drawable.beauty, getResources().getString(R.string.beauty)));

    categoryAdapter = new CategoryAdapter(categoryModelList, new OnItemClickListener() {
      @Override
      public void OnItemClick() {
        openCategoryDetailsPage();
      }
    });

    rvCategories.setLayoutManager(new GridLayoutManager(getContext(), 4));
    rvCategories.setAdapter(categoryAdapter);
  }

  //this method is use to open category details screen while clicking on any item
  private void openCategoryDetailsPage() {
    Intent intent = new Intent(getContext(), CategoryDetailsActivity.class);
    startActivity(intent);
  }

  //this method is use to set deals data on recyclerview
  private void setUpDealsAdapter() {
    layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
    trendingModelList = new ArrayList<>();
    trendingModelList.add(new TrendingModel(R.drawable.images1, getResources().getString(R.string.men), "$15.00"));
    trendingModelList.add(new TrendingModel(R.drawable.images2, getResources().getString(R.string.women), "$15.00"));
    trendingModelList.add(new TrendingModel(R.drawable.images3, getResources().getString(R.string.kids), "$20.00"));

    dealsAdapter = new DealsAdapter(trendingModelList, new OnItemClickListener() {
      @Override
      public void OnItemClick() {
        openCategoryDetailsPage();
      }
    });

    rvDealsOfDay.setLayoutManager(layoutManager);
    rvDealsOfDay.setAdapter(dealsAdapter);
  }

  //this method is use to set trending data on recyclerview
  private void setUpTrendingAdapter() {
    trendingModelList.add(new TrendingModel(R.drawable.shirts_images, getResources().getString(R.string.men), "$15.00"));
    trendingModelList.add(new TrendingModel(R.drawable.loungewear, getResources().getString(R.string.women), "$15.00"));
    trendingModelList.add(new TrendingModel(R.drawable.jeans, getResources().getString(R.string.kids), "$20.00"));
    trendingModelList.add(new TrendingModel(R.drawable.tshirts, getResources().getString(R.string.beauty), "$05.00"));

    trendingAdapter = new TrendingAdapter(trendingModelList, new OnItemClickListener() {
      @Override
      public void OnItemClick() {
        openCategoryDetailsPage();
      }
    });

    rvTrending.setLayoutManager(new GridLayoutManager(getContext(), 2));
    rvTrending.setAdapter(trendingAdapter);
    rvTrending.setNestedScrollingEnabled(false);
  }

  //this method is use to set category data on recyclerview
  private void setUpCategoryAdapter() {
    layoutManager = new LinearLayoutManager(getContext());
    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

    categoryModelList.add(new CategoryModel(R.drawable.men, getResources().getString(R.string.men)));
    categoryModelList.add(new CategoryModel(R.drawable.women, getResources().getString(R.string.women)));
    categoryModelList.add(new CategoryModel(R.drawable.kids, getResources().getString(R.string.kids)));
    categoryModelList.add(new CategoryModel(R.drawable.beauty, getResources().getString(R.string.beauty)));
    categoryModelList.add(new CategoryModel(R.drawable.footwear, getResources().getString(R.string.footwear)));

    categoryAdapter = new CategoryAdapter(categoryModelList, new OnItemClickListener() {
      @Override
      public void OnItemClick() {
        openCategoryDetailsPage();
      }
    });

    rvCategory.setLayoutManager(layoutManager);
    rvCategory.setAdapter(categoryAdapter);
  }

  //this method is use to set data of photos and set as pager
  private void setUpViewPagerAndTab() {
    photosUrl.add(R.drawable.silder);
    photosUrl.add(R.drawable.silder);
    HomeViewPagerAdapter adapter = new HomeViewPagerAdapter(getContext(), photosUrl, new OnItemClickListener() {
      @Override
      public void OnItemClick() {
        openCategoryDetailsPage();
      }
    });
    pager.setAdapter(adapter);
    tabLayout.setupWithViewPager(pager, true);
  }

}