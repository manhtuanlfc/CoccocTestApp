
package com.coccoc.coccoctestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movies {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sku")
    @Expose
    private String sku;
    @SerializedName("category_id")
    @Expose
    private Integer categoryId;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("movie_trailer")
    @Expose
    private String movieTrailer;
    @SerializedName("movie_event")
    @Expose
    private String movieEvent;
    @SerializedName("rating_code")
    @Expose
    private String ratingCode;
    @SerializedName("rating_icon")
    @Expose
    private String ratingIcon;
    @SerializedName("codes")
    @Expose
    private String codes;
    @SerializedName("is_booking")
    @Expose
    private Boolean isBooking;
    @SerializedName("is_sneakshow")
    @Expose
    private Boolean isSneakshow;
    @SerializedName("is_new")
    @Expose
    private Boolean isNew;
    @SerializedName("position")
    @Expose
    private Integer position;
    @SerializedName("movie_endtime")
    @Expose
    private Integer movieEndtime;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("is_gerp")
    @Expose
    private Boolean isGerp;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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

    public String getMovieTrailer() {
        return movieTrailer;
    }

    public void setMovieTrailer(String movieTrailer) {
        this.movieTrailer = movieTrailer;
    }

    public String getMovieEvent() {
        return movieEvent;
    }

    public void setMovieEvent(String movieEvent) {
        this.movieEvent = movieEvent;
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

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public Boolean getIsBooking() {
        return isBooking;
    }

    public void setIsBooking(Boolean isBooking) {
        this.isBooking = isBooking;
    }

    public Boolean getIsSneakshow() {
        return isSneakshow;
    }

    public void setIsSneakshow(Boolean isSneakshow) {
        this.isSneakshow = isSneakshow;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getMovieEndtime() {
        return movieEndtime;
    }

    public void setMovieEndtime(Integer movieEndtime) {
        this.movieEndtime = movieEndtime;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getIsGerp() {
        return isGerp;
    }

    public void setIsGerp(Boolean isGerp) {
        this.isGerp = isGerp;
    }

}
