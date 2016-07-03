package com.tinoba.githubsearch;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;
import retrofit2.Response;

/**
 * Created by tinoba on 1.7.2016..
 */
public class QueryFragment extends Fragment {
    private static final String DESCRIBABLE_KEY = "listKey";
    ArrayList<Items> itemsList;
    GetDataInterface getDataInterface;
    private NetworkService service;
    private PrecenterInteractor presenter;
    @BindView(R.id.inputQuery)
    EditText inputQuery;
    @BindView(R.id.spinSort)
    Spinner spinSort;
    @BindView(R.id.listRepositories)
    ListView listRepositories;
    final String[] str={"stars","forks","updated"};
    @OnClick(R.id.btnSearch)
    public void clicked() {
        String query = inputQuery.getText().toString();
        String sort = spinSort.getSelectedItem().toString();
        presenter.loadRetroData(query,sort);

    }
    public void onImgClick(int position) {
        getDataInterface.getDataList(itemsList.get(position));

    }
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repository_query_fragment,container,false);
        ButterKnife.bind(this,view);

        ArrayAdapter<String> adp1=new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,str);
        adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinSort.setAdapter(adp1);
        if(itemsList!= null){
            ListAdapter customAdapter = new CustomListAdapter(getActivity(),itemsList,this);
            listRepositories.setAdapter(customAdapter);
        }
        service = ((RxApplication)getActivity().getApplication()).getNetworkService();
        presenter = new PresenterLayer(this, service);
        return view;
    }
    public interface GetDataInterface{
        public void  getDataList(Items item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            getDataInterface = (GetDataInterface)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "must implement interface");
        }
    }

    protected void showRetroResults(Response<Repository> response){
        itemsList = response.body().getItems();
        setAdapter();

    }
    private void setAdapter(){
        ListAdapter customAdapter = new CustomListAdapter(getActivity(),itemsList,this);
        listRepositories.setAdapter(customAdapter);
    }

}
