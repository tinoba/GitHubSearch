package com.tinoba.githubsearch.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.tinoba.githubsearch.POJO.Items;
import com.tinoba.githubsearch.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tinoba on 3.7.2016..
 */
public class UserDetailFragment extends Fragment{
    private static final String DESCRIBABLE_KEY = "key";

    private Items mitem;
    @BindView(R.id.txtLogin)
    TextView txtLogin;
    @BindView(R.id.txtId)
    TextView txtId;
    @BindView(R.id.txtEvents)
    TextView txtEvents;
    @BindView(R.id.txtType)
    TextView txtType;
    @BindView(R.id.txtAdmin)
    TextView txtAdmin;
    @BindView(R.id.txtRepos)
    TextView txtRepos;
    @BindView(R.id.txtHtml)
    TextView txtHtml;
    @BindView(R.id.imgThumbnail)
    ImageView imgThumbnail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_detail_fragment,container,false);
        ButterKnife.bind(this,view);

        mitem = (Items) getArguments().getSerializable(DESCRIBABLE_KEY);
        displayData(mitem);
        return view;
    }
    public void displayData(Items item){
        txtLogin.setText(item.getOwner().getLogin());
        txtId.setText(String.valueOf(item.getOwner().getId()));
        txtEvents.setText(item.getOwner().getReceived_events_url());
        txtType.setText(item.getOwner().getType());
        txtAdmin.setText(String.valueOf(item.getOwner().getSite_admin()));
        txtRepos.setText(item.getOwner().getRepos_url());
        txtHtml.setText(item.getOwner().getHtml_url());
        Picasso.with(getActivity())
                .load(item.getOwner().getAvatar_url())
                .into(imgThumbnail);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().getFragmentManager().popBackStack();
    }

    public static UserDetailFragment newInstance(Items item) {
        UserDetailFragment fragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESCRIBABLE_KEY,item);
        fragment.setArguments(bundle);
        return fragment;
    }
    @OnClick(R.id.btnBrowser)
    public void browserClicked(View view){
        String url = mitem.getOwner().getUrl();
        Intent browserIntent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        getActivity().startActivity(browserIntent);
    }

}
