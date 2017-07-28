package com.coccoc.coccoctestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by manht on 7/27/2017.
 */

public class MovieDetails {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("full_description")
    @Expose
    private String fullDescription;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("rating_code")
    @Expose
    private String ratingCode;
    @SerializedName("rating_icon")
    @Expose
    private String ratingIcon;
    @SerializedName("review_percent")
    @Expose
    private String reviewPercent;
    @SerializedName("codes")
    @Expose
    private String codes;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("movie_trailer")
    @Expose
    private String movieTrailer;
    @SerializedName("movie_director")
    @Expose
    private String movieDirector;
    @SerializedName("movie_language")
    @Expose
    private String movieLanguage;
    @SerializedName("movie_endtime")
    @Expose
    private Integer movieEndtime;
    @SerializedName("movie_actress")
    @Expose
    private String movieActress;
    @SerializedName("is_booking")
    @Expose
    private Boolean isBooking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(String ratingCode) {
        this.ratingCode = ratingCode;
    }

    public String getRatingIcon() {
        return ratingIcon;
    }

    public void setRatingIcon(String ratingIcon) {
        this.ratingIcon = ratingIcon;
    }

    public String getReviewPercent() {
        return reviewPercent;
    }

    public void setReviewPercent(String reviewPercent) {
        this.reviewPercent = reviewPercent;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getMovieDirector() {
        return movieDirector;
    }

    public void setMovieDirector(String movieDirector) {
        this.movieDirector = movieDirector;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public Integer getMovieEndtime() {
        return movieEndtime;
    }

    public void setMovieEndtime(Integer movieEndtime) {
        this.movieEndtime = movieEndtime;
    }

    public String getMovieActress() {
        return movieActress;
    }

    public void setMovieActress(String movieActress) {
        this.movieActress = movieActress;
    }

    public Boolean getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(Boolean isBooking) {
        this.isBooking = isBooking;
    }

}

