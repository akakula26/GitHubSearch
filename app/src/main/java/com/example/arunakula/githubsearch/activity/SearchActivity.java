package com.example.arunakula.githubsearch.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ActionMenuView;
import android.widget.RelativeLayout;


import com.example.arunakula.githubsearch.rest.ApiClient;
import com.example.arunakula.githubsearch.rest.ApiInterface;
import com.example.arunakula.githubsearch.R;
import com.example.arunakula.githubsearch.adapter.SearchAdapter;
import com.example.arunakula.githubsearch.model.Search;
import com.example.arunakula.githubsearch.model.SearchReceived;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchActivity extends Activity {
    private String receivedSearchName;
    private RecyclerView mRecyclerView;
    private List<Search> myDataSource = new ArrayList<>();
    private RecyclerView.Adapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        Bundle bundle = getIntent().getExtras();
        receivedSearchName = bundle.getString("key");
        Log.v("SearchActivity", "receivedSearchName :" + receivedSearchName);
        mRecyclerView = (RecyclerView) findViewById(R.id.serach_recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new SearchAdapter(myDataSource, getApplicationContext(), R.layout.search_list);
        mRecyclerView.setAdapter(myAdapter);
        loadData();
    }

    public void loadData() {
        final ApiInterface apiService = ApiClient.getApiClient().create(ApiInterface.class);
        Call<SearchReceived> call = apiService.githubSearch(receivedSearchName);
        call.enqueue(new Callback<SearchReceived>() {
            @Override
            public void onResponse(Call<SearchReceived> call, Response<SearchReceived> response) {
                Log.v("SearchActivity","receivedSearchName toString :"+response.toString());
                Log.v("SearchActivity","receivedSearchName body:"+response.body());
                myDataSource.clear();
                myDataSource.addAll(response.body().getSearch());
                myAdapter.notifyDataSetChanged();

                List<Search> searchs = response.body().getSearch();
                for (Search search : searchs) {

                    Log.v("SearchActivity","Name:"+search.getName() +"Full Name :"+search.getFull_Name()+"Private:"+search.getPrivate());

                }

            }

            @Override
            public void onFailure(Call<SearchReceived> call, Throwable t) {

            }
        });
    }
}
