package com.tinoba.githubsearch.POJO;

import com.tinoba.githubsearch.POJO.Items;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by tinoba on 28.6.2016..
 */
public class Repository implements Serializable{
    ArrayList<Items> items;

    public ArrayList<Items> getItems() {
        return items;
    }

    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }
}
