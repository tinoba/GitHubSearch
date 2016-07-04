package com.tinoba.githubsearch.helpers;

import com.tinoba.githubsearch.Network.NetworkService;
import com.tinoba.githubsearch.POJO.Repository;
import com.tinoba.githubsearch.fragments.QueryFragment;
import com.tinoba.githubsearch.interfaces.PrecenterInteractor;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by tinoba on 30.6.2016..
 */
public class PresenterLayer implements PrecenterInteractor {
    private NetworkService service;
    private QueryFragment view;

    public PresenterLayer(QueryFragment view, NetworkService service){
        this.view = view;
        this.service = service;

    }
    @Override
    public void loadRetroData(String query,String sort) {
        Call<Repository> call = service.getAPI().getRepositories(query,sort);
        call.enqueue(new Callback<Repository>() {
            @Override
            public void onResponse(Call<Repository> call, Response<Repository> response) {
                if(response.body()!=null) {
                    view.showRetroResults(response);
                }
            }

            @Override
            public void onFailure(Call<Repository> call, Throwable t) {

            }
        });
    }
}
