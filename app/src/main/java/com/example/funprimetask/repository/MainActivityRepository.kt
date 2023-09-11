package com.example.funprimetask.repository

import androidx.lifecycle.MutableLiveData
import com.example.funprimetask.model.DataResponse
import com.example.funprimetask.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val data_Response = MutableLiveData<DataResponse>()

    fun getPhotosApiCall(): MutableLiveData<DataResponse> {

        val call = RetrofitClient.apiInterface.getPhotos()

        call.enqueue(object: Callback<DataResponse> {
            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<DataResponse>,
                response: Response<DataResponse>
            ) {
                val data = response.body()
                val photosList = data
                data_Response.postValue(photosList)

            }
        })

        return data_Response
    }
}