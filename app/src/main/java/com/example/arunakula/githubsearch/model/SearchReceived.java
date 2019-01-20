package com.example.arunakula.githubsearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchReceived {

    public List<Search> getSearch() {
        return search;
    }

    public void setSearch(List<Search> search) {
        this.search = search;
    }

    @SerializedName("items")
    private List<Search> search;



}
