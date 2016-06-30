package com.tinoba.githubsearch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tinoba on 30.6.2016..
 */
public class NetworkService {
    private static String baseUrl ="https://api.github.com";
    private GitHubRetrofitAPI gitHubRetrofitAPI;
    public NetworkService(){
        this(baseUrl);
    }
    public NetworkService(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitHubRetrofitAPI = retrofit.create(GitHubRetrofitAPI.class);
    }
    public GitHubRetrofitAPI getAPI(){
        return  gitHubRetrofitAPI;
    }

}
