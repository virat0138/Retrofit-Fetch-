package com.kazimasum.retrodemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface myapi
{
  @GET("posts")
  Call<List<model>> getmodels();
}
