package com.example.funprimetask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.funprimetask.model.DataResponse
import com.example.funprimetask.repository.MainActivityRepository

class MainActivityViewModel : ViewModel() {

    var photosLiveData: MutableLiveData<DataResponse>? = null

    fun getUser() : LiveData<DataResponse>? {
        photosLiveData = MainActivityRepository.getPhotosApiCall()
        return photosLiveData
    }

}