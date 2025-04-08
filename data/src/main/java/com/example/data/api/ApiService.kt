package com.example.data.api

import com.example.data.model.SchoolDetailModel
import com.example.data.model.SchoolListModel
import retrofit2.http.GET

interface ApiService {

    @GET("/s3k6-pzi2.json")
    suspend fun getSchoolList(): List<SchoolListModel>

    @GET("/f9bf-2cp4.json")
    suspend fun getSchoolDetails(): List<SchoolDetailModel>

}
