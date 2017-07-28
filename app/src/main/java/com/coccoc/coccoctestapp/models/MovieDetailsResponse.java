package com.coccoc.coccoctestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manht on 7/28/2017.
 */

public class MovieDetailsResponse {
    @SerializedName("data")
    @Expose
    private MovieDetails data;

    public MovieDetails getData() {
        return data;
    }

    public void setData(MovieDetails data) {
        this.data = data;
    }
}
