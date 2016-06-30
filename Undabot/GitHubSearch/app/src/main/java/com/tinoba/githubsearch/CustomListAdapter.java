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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tinoba on 28.6.2016..
 */
public class CustomListAdapter extends ArrayAdapter<Items>{

    ArrayList<Items> listaRepozitorija;
    Context context;
    public CustomListAdapter(Context context, ArrayList<Items> listaRepozitorija) {
        super(context, R.layout.query_row,listaRepozitorija);
        this.listaRepozitorija = listaRepozitorija;
        this.context = context;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
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

        return view;

    }
    static class ViewHolder {
        @BindView(R.id.txtImeRepozitorija) TextView txtImeRepozitorija;
        @BindView(R.id.txtImeAutora) TextView txtImeAutora;
        @BindView(R.id.txtBrojForkova) TextView txtBrojForkova;
        @BindView(R.id.txtBrojIssuea) TextView txtBrojIssuea;
        @BindView(R.id.txtBrojPratitelja) TextView txtBrojPratitelja;
        @BindView(R.id.imgSlika) ImageView imgSlika;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

}

