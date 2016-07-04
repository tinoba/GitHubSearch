package com.tinoba.githubsearch.activities;



import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tinoba.githubsearch.POJO.Items;
import com.tinoba.githubsearch.fragments.QueryFragment;
import com.tinoba.githubsearch.R;
import com.tinoba.githubsearch.fragments.RepositoryDetailsFragment;
import com.tinoba.githubsearch.fragments.UserDetailFragment;


public class RepositorySearchActivity extends AppCompatActivity implements QueryFragment.GetDataInterface, RepositoryDetailsFragment.GetUserInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_search);
        Fragment queryFragment = new QueryFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltLayout, queryFragment)
                .commit();
    }


    @Override
    public void getDataList(Items item, int id) {
        if(id == R.id.rltvPodaci) {
            RepositoryDetailsFragment repositoryDetailsFragment = RepositoryDetailsFragment.newInstance(item);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.rltLayout, repositoryDetailsFragment)
                    .addToBackStack("tag").commit();
        }
        else if(id == R.id.imgSlika){
            UserDetailFragment userDetailFragment = UserDetailFragment.newInstance(item);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.rltLayout, userDetailFragment)
                    .addToBackStack("tag").commit();

        }
    }

    @Override
    public void getUser(Items item) {
        UserDetailFragment userDetailFragment = UserDetailFragment.newInstance(item);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.rltLayout, userDetailFragment).
                addToBackStack(null).commit();
    }
}
