package com.example.funprimetask.retrofit

import com.example.funprimetask.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getPhotos() : Call<DataResponse>

}