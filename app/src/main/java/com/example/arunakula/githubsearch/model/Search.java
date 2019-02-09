package com.example.arunakula.githubsearch.model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Search {


    @SerializedName("name")
    private String Name;

    @SerializedName("private")
    private String Private;

    @SerializedName("full_name")
    private String Full_Name;

    @SerializedName("avatar_url")
    private String Avatar_Url;

    @SerializedName("description")
    private String Description;


    @SerializedName("stargazers_count")
    private String Star_Count;

    @SerializedName("owner")
    private HashMap<String,String> owner = new HashMap<>();

    public String getPrivate() {
        return Private;
    }

    public void setPrivate(String aPrivate) {
        Private = aPrivate;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }



    public HashMap<String, String> getOwner() {
        return owner;
    }

    public void setOwner(HashMap<String, String> owner) {
        this.owner = owner;
    }



    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAvatar_Url() {
        return Avatar_Url;
    }

    public void setAvatar_Url(String avatar_Url) {
        Avatar_Url = avatar_Url;
    }

    public String getStar_Count() {
        return Star_Count;
    }

    public void setStar_Count(String star_Count) {
        Star_Count = star_Count;
    }
}
