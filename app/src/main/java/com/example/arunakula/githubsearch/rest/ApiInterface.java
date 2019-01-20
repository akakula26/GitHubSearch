package com.example.arunakula.githubsearch.rest;


import com.example.arunakula.githubsearch.model.SearchReceived;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


@GET("search/repositories")
Call<SearchReceived> githubSearch(@Query("q") String search);
}
