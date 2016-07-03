package com.tinoba.githubsearch;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


/**
 * Created by tinoba on 28.6.2016..
 */
public class Items implements Serializable {
    String name;
    Owner owner;
    int watchers_count;
    int forks_count;
    int open_issues;
    String language;
    String created_at;
    String updated_at;


/*
    public Items(Parcel in){
        name = in.readString();
        watchers_count = in.readInt();
        forks_count = in.readInt();
        open_issues = in.readInt();
        owner = in.readParcelable(Owner.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(watchers_count);
        out.writeInt(forks_count);
        out.writeInt(open_issues);
        out.writeParcelable(owner, flags);
    }*/

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public int getWatchers_count() {
        return watchers_count;
    }

    public void setWatchers_count(int watchers_count) {
        this.watchers_count = watchers_count;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public int getOpen_issues() {
        return open_issues;
    }

    public void setOpen_issues(int open_issues) {
        this.open_issues = open_issues;
    }
}
