package com.example.data.model

import com.google.gson.annotations.SerializedName

data class SchoolListModel(
    @SerializedName("dbn")
    val schoolId: Int,
    @SerializedName("school_name")
    val schoolName: String
)
