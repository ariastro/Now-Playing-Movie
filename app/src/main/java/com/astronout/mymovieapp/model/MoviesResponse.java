package com.astronout.mymovieapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("results")
    private List<Movie> mResults;
    @SerializedName("page")
    private Long mPage;
    @SerializedName("total_results")
    private Long mTotalResults;
    @SerializedName("total_pages")
    private Long mTotalPages;

    public List<Movie> getmResults() {
        return mResults;
    }

    public void setmResults(List<Movie> mResults) {
        this.mResults = mResults;
    }

    public Long getmPage() {
        return mPage;
    }

    public void setmPage(Long mPage) {
        this.mPage = mPage;
    }

    public Long getmTotalResults() {
        return mTotalResults;
    }

    public void setmTotalResults(Long mTotalResults) {
        this.mTotalResults = mTotalResults;
    }

    public Long getmTotalPages() {
        return mTotalPages;
    }

    public void setmTotalPages(Long mTotalPages) {
        this.mTotalPages = mTotalPages;
    }
}
