package com.tinoba.githubsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RepositorySearch extends AppCompatActivity {
    public static final String BASE_URL = "https://api.github.com";
    Button btnSearch;
    EditText inputQuery;
    final String[] str={"stars","forks","updated"};
    Spinner spinSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);
        btnSearch = (Button)findViewById(R.id.btnSearch);
        inputQuery = (EditText)findViewById(R.id.inputQuery);
        spinSort = (Spinner)findViewById(R.id.spinSort);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,str);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adp1);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = inputQuery.getText().toString();
                String sort = spinSort.getSelectedItem().toString();
                Log.i("TAG",sort);
                search(query,sort);
            }
        });

    }
    private void search(String query,String sort){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubRetrofit apiService =
                retrofit.create(GitHubRetrofit.class);
        Call<Repository> call = apiService.getRepositories(query,sort);
        call.enqueue(new Callback<Repository>  () {
            @Override
            public void onResponse(Call<Repository>   call, Response<Repository>  response) {

                if(response.body() == null){
                    Log.i("TAG",call.request().toString());

                }
                else {
                    if(response.body().getItems()==null) {
                        Log.i("TAG", "nula je lista");
                    }
                    else{
                        ArrayList<Items> lista = response.body().getItems();
                        ListView listView = (ListView)findViewById(R.id.listView);
                        ListAdapter customAdapter = new CustomListAdapter(RepositorySearch.this,lista);
                        listView.setAdapter(customAdapter);
                        Log.i("TAG",call.request().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<Repository>   call, Throwable t) {
                Log.i("TAG", call.request().toString()+" krivo");
                Log.i("TAG",t.getMessage());
            }
        });
    }
}
