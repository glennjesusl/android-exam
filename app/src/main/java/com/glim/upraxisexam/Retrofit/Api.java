package com.glim.upraxisexam.Retrofit;

import com.glim.upraxisexam.Models.DetailModel;
import com.glim.upraxisexam.Models.ListingModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface Api {

    //--getting all the list of people
    @GET
    Call<ListingModel> getListing(
            @Url String url);

    //--getting detail of selected item
    @GET
    Call<DetailModel> getDetails(
            @Url String url);



}
