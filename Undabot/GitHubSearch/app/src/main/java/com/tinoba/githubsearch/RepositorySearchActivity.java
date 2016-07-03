package com.tinoba.githubsearch;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import butterknife.OnItemClick;

public class RepositorySearchActivity extends AppCompatActivity implements QueryFragment.GetDataInterface{
    /*
    private NetworkService service;
    private PrecenterInteractor presenter;
    @BindView(R.id.inputQuery) EditText inputQuery;
    @BindView(R.id.spinSort) Spinner spinSort;
    @BindView(R.id.listRepositories) ListView listRepositories;
    final String[] str={"stars","forks","updated"};
    @OnClick(R.id.btnSearch)
    public void clicked(Button button) {
        String query = inputQuery.getText().toString();
        String sort = spinSort.getSelectedItem().toString();
        presenter.loadRetroData(query,sort);

        Fragment queryFragment = new QueryFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltvLayout, queryFragment);
        fragmentTransaction.commit();
    }
    @OnItemClick(R.id.listRepositories)
    void onItemClicked(int position) {
        Fragment repositoryDetailsFragment = new RepositoryDetailsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltvLayout, repositoryDetailsFragment);
        fragmentTransaction.commit();
        Toast.makeText(this,"bok "+position,Toast.LENGTH_LONG).show();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);
        Fragment queryFragment = new QueryFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltLayout, queryFragment)
                .commit();
        /*
        ButterKnife.bind(this);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,str);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adp1);

        service = ((RxApplication)getApplication()).getNetworkService();
        presenter = new PresenterLayer(this, service);*/
    }
/*
    protected void showRetroResults(Response<Repository> response){
        ListAdapter customAdapter = new CustomListAdapter(RepositorySearchActivity.this,response.body().getItems());
        listRepositories.setAdapter(customAdapter);

    }*/

    @Override
    public void getDataList(Items item) {
       // Log.i("TAG",String.valueOf(item.getName()));

        RepositoryDetailsFragment repositoryDetailsFragment = RepositoryDetailsFragment.newInstance(item);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltLayout, repositoryDetailsFragment)
                .addToBackStack("tag").commit();
    }
}
