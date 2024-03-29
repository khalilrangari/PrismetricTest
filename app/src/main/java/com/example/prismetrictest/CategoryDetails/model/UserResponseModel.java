package com.example.prismetrictest.CategoryDetails.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponseModel {

  @SerializedName("id")
  @Expose
  private Integer id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("username")
  @Expose
  private String username;
  @SerializedName("email")
  @Expose
  private String email;
  @SerializedName("address")
  @Expose
  private UserAddress address;
  @SerializedName("phone")
  @Expose
  private String phone;
  @SerializedName("website")
  @Expose
  private String website;
  @SerializedName("company")
  @Expose
  private CompanyDetails company;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserAddress getAddress() {
    return address;
  }

  public void setAddress(UserAddress address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getWebsite() {
    return website;
  }

  public void setWebsite(String website) {
    this.website = website;
  }

  public CompanyDetails getCompany() {
    return company;
  }

  public void setCompany(CompanyDetails company) {
    this.company = company;
  }
}
