package com.tinoba.githubsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tinoba on 28.6.2016..
 */
public class CustomListAdapter extends ArrayAdapter<Items>{
    ArrayList<Items> listaRepozitorija;
    TextView txtImeRepozitorija;
    TextView txtImeAutora;
    TextView txtBrojForkova;
    TextView txtBrojIssuea;
    TextView txtBrojPratitelja;
    Context context;
    public CustomListAdapter(Context context, ArrayList<Items> listaRepozitorija) {
        super(context, R.layout.query_row,listaRepozitorija);
        this.listaRepozitorija = listaRepozitorija;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.query_row,parent,false);
        txtImeRepozitorija = (TextView)customView.findViewById(R.id.txtImeRepozitorija);
        txtImeAutora = (TextView)customView.findViewById(R.id.txtImeAutora);
        txtBrojForkova = (TextView)customView.findViewById(R.id.txtBrojForkova);
        txtBrojPratitelja = (TextView)customView.findViewById(R.id.txtBrojPratitelja);
        txtBrojIssuea = (TextView)customView.findViewById(R.id.txtBrojIssuea);
        txtImeRepozitorija.setText(listaRepozitorija.get(position).getName());
        txtImeAutora.setText(listaRepozitorija.get(position).getOwner().getLogin());
        txtBrojForkova.setText(String.valueOf(listaRepozitorija.get(position).getForks_count()));
        txtBrojPratitelja.setText(String.valueOf(listaRepozitorija.get(position).getWatchers_count()));
        txtBrojIssuea.setText(String.valueOf(listaRepozitorija.get(position).getOpen_issues()));
        ImageView imageView = (ImageView) customView.findViewById(R.id.imgSlika);
//Loading image from below url into imageView

        Picasso.with(context)
                .load(listaRepozitorija.get(position).getOwner().getAvatar_url())
                .into(imageView);
        return customView;
    }
}
