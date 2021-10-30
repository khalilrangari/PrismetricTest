package com.example.prismetrictest.CategoryDetails;

import static com.example.prismetrictest.Util.Constance.ZERO;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.prismetrictest.CategoryDetails.Adapter.CategoryDetailListAdapter;
import com.example.prismetrictest.CategoryDetails.model.UserResponseModel;
import com.example.prismetrictest.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryDetailsActivity extends AppCompatActivity implements CategoryDetailsContract.CategoryView{

  @BindView(R.id.rvCategoryDetails)
  RecyclerView rvCategoryDetails;
  @BindView(R.id.progressBar)
  ProgressBar progressBar;

  CategoryDetailListAdapter categoryDeatilListAdapter;
  LinearLayoutManager linearLayoutManager;
  List<UserResponseModel> userResponseModelList = new ArrayList<>();

  CategoryDetailsContract.CategoryPresenter categoryPresenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category_details);
    ButterKnife.bind(this);
    categoryPresenter = new CategoryDetailsPresenter(CategoryDetailsActivity.this);
    categoryPresenter.getUserData();
  }

  @Override
  public void showErrorMsg(String errorMsg) {
    Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void hideProgressBar() {
    progressBar.setVisibility(View.GONE);
  }

  @Override
  public void showProgressBar() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @SuppressLint("NotifyDataSetChanged")
  @Override
  public void responseSuccess(List<UserResponseModel> usersData) {
    if (userResponseModelList != null && userResponseModelList.size() > ZERO){
      userResponseModelList.clear();
    }
    userResponseModelList = usersData;

    linearLayoutManager = new LinearLayoutManager(this);
    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    categoryDeatilListAdapter = new CategoryDetailListAdapter(userResponseModelList);

    rvCategoryDetails.setLayoutManager(linearLayoutManager);
    rvCategoryDetails.setAdapter(categoryDeatilListAdapter);

    categoryDeatilListAdapter.notifyDataSetChanged();
  }
}