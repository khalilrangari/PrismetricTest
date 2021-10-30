package com.example.prismetrictest.HomeScreen.model;

public class TrendingModel {

  private int trendingImage;
  private String trendingText,amount;

  public TrendingModel(int trendingImage, String trendingText,String amount) {
    this.trendingImage = trendingImage;
    this.trendingText = trendingText;
    this.amount = amount;
  }

  public int getTrendingImage() {
    return trendingImage;
  }

  public void setTrendingImage(int trendingImage) {
    this.trendingImage = trendingImage;
  }

  public String getTrendingText() {
    return trendingText;
  }

  public void setTrendingText(String trendingText) {
    this.trendingText = trendingText;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }
}
