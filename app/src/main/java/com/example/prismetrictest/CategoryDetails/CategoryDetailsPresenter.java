package com.example.prismetrictest.CategoryDetails;

import android.content.Context;
import android.util.Log;

import com.example.prismetrictest.CategoryDetails.model.UserResponseModel;
import com.example.prismetrictest.NetworkService.APIClient;
import com.example.prismetrictest.NetworkService.APIInterface;
import com.example.prismetrictest.R;
import com.example.prismetrictest.Util.Utility;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetailsPresenter implements CategoryDetailsContract.CategoryPresenter{

  public static final String TAG = CategoryDetailsPresenter.class.getSimpleName();
  private CategoryDetailsContract.CategoryView categoryView;
  private Context mContext;
  private APIInterface apiInterface;

  CategoryDetailsPresenter(Object view) {
    categoryView = (CategoryDetailsActivity) view;
    this.mContext = ((CategoryDetailsActivity) view).getBaseContext();
    this.apiInterface = APIClient.getClient().create(APIInterface.class);
  }

  @Override
  public void getUserData() {
    if (Utility.isInternetAvailable(mContext)) {
      categoryView.showProgressBar();

      Call<List<UserResponseModel>> call = apiInterface.getProfileList();
      call.enqueue(new Callback<List<UserResponseModel>>() {
        @Override
        public void onResponse(@NotNull Call<List<UserResponseModel>> call, @NotNull Response<List<UserResponseModel>> response) {
          categoryView.hideProgressBar();
          if (response != null && response.isSuccessful()) {
            if (response.body() != null) {
              Log.e(TAG,"getUserData Response : "+response.body().toString());
              categoryView.responseSuccess(response.body());
            } else {
              categoryView.showErrorMsg(response.errorBody().toString());
            }
          }
        }

        @Override
        public void onFailure(@NotNull Call<List<UserResponseModel>> call, @NotNull Throwable t) {
          categoryView.showErrorMsg(mContext.getResources().getString(R.string.somethingIsWrong));
          categoryView.showProgressBar();
        }
      });
    } else {
      categoryView.showErrorMsg(mContext.getResources().getString(R.string.checkInternetConnection));
      categoryView.hideProgressBar();
    }
  }
}
