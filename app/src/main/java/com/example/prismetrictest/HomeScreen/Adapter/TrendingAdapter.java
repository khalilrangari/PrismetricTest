package com.example.prismetrictest.HomeScreen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.prismetrictest.HomeScreen.model.CategoryModel;
import com.example.prismetrictest.HomeScreen.model.TrendingModel;
import com.example.prismetrictest.R;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyViewHolder> {

  private ArrayList<TrendingModel> trendingModelList = new ArrayList<>();
  private Context mContext;
  private OnItemClickListener onItemClickListener;

  public TrendingAdapter(ArrayList<TrendingModel> trendingModelList, OnItemClickListener onItemClickListener) {
    this.trendingModelList = trendingModelList;
    this.onItemClickListener = onItemClickListener;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    this.mContext = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem= layoutInflater.inflate(R.layout.item_trending, parent, false);
    MyViewHolder viewHolder = new MyViewHolder(listItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    Glide.with(mContext)
        .load(trendingModelList.get(position).getTrendingImage())
        .into(holder.ivTrending);

    holder.tvAmount.setText(trendingModelList.get(position).getAmount());
    holder.tvTitle.setText(trendingModelList.get(position).getTrendingText());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onItemClickListener.OnItemClick();
      }
    });
  }

  @Override
  public int getItemCount() {
    return trendingModelList.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView ivTrending;
    TextView tvAmount,tvTitle;
    public MyViewHolder(View itemView) {
      super(itemView);
      ivTrending = itemView.findViewById(R.id.ivTrending);
      tvAmount = itemView.findViewById(R.id.tvAmount);
      tvTitle = itemView.findViewById(R.id.tvTitle);
    }
  }
}
