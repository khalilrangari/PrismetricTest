package com.example.prismetrictest.HomeScreen.Adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.prismetrictest.HomeScreen.model.CategoryModel;
import com.example.prismetrictest.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

  private ArrayList<CategoryModel> categoryModelList = new ArrayList<>();
  private Context mContext;
  private OnItemClickListener onItemClickListener;

  public CategoryAdapter(ArrayList<CategoryModel> categoryModelList,OnItemClickListener mOnItemClickListener) {
    this.categoryModelList = categoryModelList;
    this.onItemClickListener = mOnItemClickListener;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    this.mContext = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem= layoutInflater.inflate(R.layout.item_category, parent, false);
    MyViewHolder viewHolder = new MyViewHolder(listItem);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    Glide.with(mContext)
        .load(categoryModelList.get(position).getCategoryImage())
        .circleCrop()
        .into(holder.ivCategory);

    holder.tvCategory.setText(categoryModelList.get(position).getCategoryText());
    holder.tvCategory.setAllCaps(true);

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        onItemClickListener.OnItemClick();
      }
    });
  }

  @Override
  public int getItemCount() {
    return categoryModelList.size();
  }

  public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView ivCategory;
    TextView tvCategory;
    public MyViewHolder(View itemView) {
      super(itemView);
      ivCategory = itemView.findViewById(R.id.ivCategory);
      tvCategory = itemView.findViewById(R.id.tvCategory);
    }
  }
}
