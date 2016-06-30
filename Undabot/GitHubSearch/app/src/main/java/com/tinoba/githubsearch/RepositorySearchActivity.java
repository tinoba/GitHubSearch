package com.tinoba.githubsearch;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;
import retrofit2.Response;

public class RepositorySearchActivity extends AppCompatActivity {
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
    }
    @OnItemClick(R.id.listRepositories)
    void onItemClicked(int position) {
        Fragment detailFragment = new RepositoryDetailsFragment();
        Integer fragmentId = R.id.fragmentDetails;
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(fragmentId, detailFragment);
        fragmentTransaction.commit();
        Toast.makeText(this,"bok "+position,Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);
        ButterKnife.bind(this);
        ArrayAdapter<String> adp1=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,str);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adp1);

        service = ((RxApplication)getApplication()).getNetworkService();
        presenter = new PresenterLayer(this, service);
    }

    protected void showRetroResults(Response<Repository> response){
        ListAdapter customAdapter = new CustomListAdapter(RepositorySearchActivity.this,response.body().getItems());
        listRepositories.setAdapter(customAdapter);

    }

}
