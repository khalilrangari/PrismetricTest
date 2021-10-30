package com.example.prismetrictest.CategoryDetails;

import com.example.prismetrictest.CategoryDetails.model.UserResponseModel;

import java.util.List;

public interface CategoryDetailsContract {
  interface CategoryView {

    void showErrorMsg(String errorMsg);

    void hideProgressBar();

    void showProgressBar();

    void responseSuccess(List<UserResponseModel> usersData);
  }

  interface CategoryPresenter {
    void getUserData();
  }
}
