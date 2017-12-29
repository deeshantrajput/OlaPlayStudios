package com.deeshantrajput.olaplaystudios.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by deeshantrajput on 12/17/17.
 */

public class Result {
    @SerializedName("song")
    @Expose
    private String song ;

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String getCover_image() {
        return cover_image;
    }

    public void setCover_image(String cover_image) {
        this.cover_image = cover_image;
    }

    @SerializedName("url")
    @Expose
    private String url ;

    @SerializedName("artists")
    @Expose
    private String artists ;

    @SerializedName("cover_image")
    @Expose
    private String cover_image ;

}
