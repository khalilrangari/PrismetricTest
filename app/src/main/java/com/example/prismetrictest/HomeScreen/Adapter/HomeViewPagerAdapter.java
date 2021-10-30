package com.example.prismetrictest.HomeScreen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.prismetrictest.R;

import java.util.ArrayList;

public class HomeViewPagerAdapter extends PagerAdapter {

  ArrayList<Integer> pager;
  Context mContext;
  private OnItemClickListener onItemClickListener;

  public HomeViewPagerAdapter(Context mContext,ArrayList<Integer> pager, OnItemClickListener onItemClickListener) {
    this.pager = pager;
    this.mContext = mContext;
    this.onItemClickListener = onItemClickListener;
  }

  @Override
  public int getCount() {
    return pager.size();
  }

  @Override
  public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
    return view == object;
  }

  @NonNull
  @Override
  public Object instantiateItem(@NonNull ViewGroup container, int position) {
    View view = LayoutInflater.from(mContext).inflate(R.layout.pager_item, container, false);
    ImageView imageView = (ImageView) view.findViewById(R.id.image);
    imageView.setBackgroundResource(pager.get(position));
    container.addView(view);
    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onItemClickListener.OnItemClick();
      }
    });
    return view;
  }

  @Override
  public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    container.removeView((View) object);
  }

  @Override
  public int getItemPosition(@NonNull Object object) {
    return super.getItemPosition(object);
  }
}
