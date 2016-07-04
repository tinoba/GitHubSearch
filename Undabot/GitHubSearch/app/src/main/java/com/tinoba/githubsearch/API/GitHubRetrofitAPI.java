package com.tinoba.githubsearch.API;



import com.tinoba.githubsearch.POJO.Repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tinoba on 28.6.2016..
 */
public interface GitHubRetrofitAPI {
    @GET("/search/repositories")
    Call<Repository> getRepositories(@Query("q") String name, @Query("sort") String sort);
}
