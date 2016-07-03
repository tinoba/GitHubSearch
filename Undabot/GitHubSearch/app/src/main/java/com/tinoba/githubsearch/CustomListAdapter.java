package com.tinoba.githubsearch;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by tinoba on 28.6.2016..
 */
public class CustomListAdapter extends ArrayAdapter<Items>{

    ArrayList<Items> listaRepozitorija;
    Context context;
    QueryFragment fragment;
    public CustomListAdapter(Context context, ArrayList<Items> listaRepozitorija,QueryFragment fragment) {
        super(context, R.layout.query_row,listaRepozitorija);
        this.listaRepozitorija = listaRepozitorija;
        this.context = context;
        this.fragment = fragment;
    }
    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.query_row, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        holder.txtImeRepozitorija.setText(listaRepozitorija.get(position).getName());
        holder.txtImeAutora.setText(listaRepozitorija.get(position).getOwner().getLogin());
        holder.txtBrojForkova.setText(String.valueOf(listaRepozitorija.get(position).getForks_count()));
        holder.txtBrojIssuea.setText(String.valueOf(listaRepozitorija.get(position).getOpen_issues()));
        holder.txtBrojPratitelja.setText(String.valueOf(listaRepozitorija.get(position).getWatchers_count()));
        Picasso.with(context)
                .load(listaRepozitorija.get(position).getOwner().getAvatar_url())
                .into(holder.imgSlika);

        holder.imgSlika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.rltvPodaci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.onImgClick(position);
            }
        });

        return view;

    }


    static class ViewHolder {
        @BindView(R.id.txtImeRepozitorija) TextView txtImeRepozitorija;
        @BindView(R.id.txtImeAutora) TextView txtImeAutora;
        @BindView(R.id.txtBrojForkova) TextView txtBrojForkova;
        @BindView(R.id.txtBrojIssuea) TextView txtBrojIssuea;
        @BindView(R.id.txtBrojPratitelja) TextView txtBrojPratitelja;
        @BindView(R.id.imgSlika) ImageView imgSlika;
        @BindView(R.id.rltvPodaci) RelativeLayout rltvPodaci;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

