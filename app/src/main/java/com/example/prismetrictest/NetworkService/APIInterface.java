package com.example.prismetrictest.NetworkService;

import com.example.prismetrictest.CategoryDetails.model.UserResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {

  @GET("users")
  Call<List<UserResponseModel>> getProfileList();

}
