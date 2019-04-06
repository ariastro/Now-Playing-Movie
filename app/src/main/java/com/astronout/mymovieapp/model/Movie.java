package com.astronout.mymovieapp.model;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("original_title")
    private String mTitle;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("vote_average")
    private Double mVoteAverage;
    @SerializedName("release_date")
    private String mReleaseDate;
    @SerializedName("id")
    private Long mId;
    @SerializedName("backdrop_path")
    private String mBackdrop;
    @SerializedName("poster_path")
    private String mPoster;

    public Movie(String mTitle, String mOverview, Double mVoteAverage, String mReleaseDate, Long mId, String mBackdrop, String mPoster) {
        this.mTitle = mTitle;
        this.mOverview = mOverview;
        this.mVoteAverage = mVoteAverage;
        this.mReleaseDate = mReleaseDate;
        this.mId = mId;
        this.mBackdrop = mBackdrop;
        this.mPoster = mPoster;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public Double getmVoteAverage() {
        return mVoteAverage;
    }

    public void setmVoteAverage(Double mVoteAverage) {
        this.mVoteAverage = mVoteAverage;
    }

    public String getmReleaseDate() {
        return mReleaseDate;
    }

    public void setmReleaseDate(String mReleaseDate) {
        this.mReleaseDate = mReleaseDate;
    }

    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmBackdrop() {
        return "https://image.tmdb.org/t/p/w500/" + mBackdrop;
    }

    public void setmBackdrop(String mBackdrop) {
        this.mBackdrop = mBackdrop;
    }

    public String getmPoster() {
        return "https://image.tmdb.org/t/p/w500/" + mPoster;
    }

    public void setmPoster(String mPoster) {
        this.mPoster = mPoster;
    }
}
