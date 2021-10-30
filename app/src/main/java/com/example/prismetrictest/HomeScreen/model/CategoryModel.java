package com.example.prismetrictest.HomeScreen.model;

public class CategoryModel {

  private int categoryImage;
  private String categoryText;

  public CategoryModel(int categoryImage, String categoryText) {
    this.categoryImage = categoryImage;
    this.categoryText = categoryText;
  }

  public int getCategoryImage() {
    return categoryImage;
  }

  public void setCategoryImage(int categoryImage) {
    this.categoryImage = categoryImage;
  }

  public String getCategoryText() {
    return categoryText;
  }

  public void setCategoryText(String categoryText) {
    this.categoryText = categoryText;
  }
}
