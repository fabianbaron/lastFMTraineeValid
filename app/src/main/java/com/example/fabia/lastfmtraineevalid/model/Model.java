package com.example.fabia.lastfmtraineevalid.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("topartists")
    @Expose
    private TopArtistsList topartists;

    public TopArtistsList getTopArtists() {
        return topartists;
    }

    public void setTopartists(TopArtistsList topartists) {
        this.topartists = topartists;
    }

}