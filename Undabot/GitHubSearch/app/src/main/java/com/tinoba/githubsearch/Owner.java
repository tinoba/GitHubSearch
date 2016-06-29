package com.tinoba.githubsearch;

/**
 * Created by tinoba on 29.6.2016..
 */
public class Owner {
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    String login;
    String avatar_url;

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
