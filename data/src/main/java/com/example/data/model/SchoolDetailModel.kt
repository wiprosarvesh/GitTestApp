package com.example.data.model

import com.google.gson.annotations.SerializedName

data class SchoolDetailModel(
    @SerializedName("dbn")
    val schoolId: Int,
    @SerializedName("school_name")
    val schoolName: String,
    @SerializedName("num_of_sat_test_takers")
    val numOfSatTestTakers: String,
    @SerializedName("sat_critical_reading_avg_score")
    val satCriticalReadingAvgScore: String,
    @SerializedName("sat_math_avg_score")
    val satMathAvgScore: String,
    @SerializedName("sat_writing_avg_score")
    val satWritingAvgScore: String
)
