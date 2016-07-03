package com.tinoba.githubsearch;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tinoba on 30.6.2016..
 */
public class RepositoryDetailsFragment extends Fragment{


    private static final String DESCRIBABLE_KEY = "key";
    private Items mitem;


    @BindView(R.id.txtName)
    TextView txtName;
    @BindView(R.id.txtBrojPratitelja)
    TextView txtBrojPratitelja;
    @BindView(R.id.txtBrojForkova)
    TextView txtBrojForkova;
    @BindView(R.id.txtBrojIssuea)
    TextView txtBrojIssuea;
    @BindView(R.id.txtPrJezik)
    TextView txtPrJezik;
    @BindView(R.id.txtDatumKreiranja)
    TextView txtDatumKreiranja;
    @BindView(R.id.txtDatumIzmjene)
    TextView txtDatumIzmjene;
    @BindView(R.id.txtImeAutora)
    TextView txtImeAutora;
    @BindView(R.id.txtTip)
    TextView txtTip;
    @BindView(R.id.imgSlikaAutora)
    ImageView imgSlikaAutora;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.repository_detail_fragment,container,false);
        ButterKnife.bind(this,view);

        mitem = (Items) getArguments().getSerializable(DESCRIBABLE_KEY);
        displayData(mitem);
        return view;
    }
    public void displayData(Items item){
        txtName.setText(item.getName());
        txtBrojPratitelja.setText(String.valueOf(item.getWatchers_count()));
        txtBrojForkova.setText(String.valueOf(item.getForks_count()));
        txtBrojIssuea.setText(String.valueOf(item.getOpen_issues()));
        txtPrJezik.setText(item.getLanguage());
        txtDatumKreiranja.setText(item.getCreated_at());
        txtDatumIzmjene.setText(item.getUpdated_at());
        txtImeAutora.setText(item.getOwner().getLogin());
        txtTip.setText(item.getOwner().getType());
        Picasso.with(getActivity())
                .load(item.getOwner().getAvatar_url())
                .into(imgSlikaAutora);
    }

    public static RepositoryDetailsFragment newInstance(Items item) {
        RepositoryDetailsFragment fragment = new RepositoryDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(DESCRIBABLE_KEY,item);
        fragment.setArguments(bundle);
        return fragment;
    }
}
