package com.tinoba.githubsearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tinoba on 28.6.2016..
 */
public interface GitHubRetrofit {
    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("/search/repositories")
    Call<Repository> getRepositories(@Query("q") String name, @Query("sort") String sort);
}
