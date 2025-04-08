package com.example.domain.model

data class SchoolDetails(
    val schoolId: Int,
    val schoolName: String,
    val numOfSatTestTakers: String,
    val satCriticalReadingAvgScore: String,
    val satMathAvgScore: String,
    val satWritingAvgScore: String
)
