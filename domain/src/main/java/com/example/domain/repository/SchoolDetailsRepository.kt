package com.example.domain.repository

import com.example.domain.model.SchoolDetails

interface SchoolDetailsRepository {

    suspend fun getSchoolDetails(): List<SchoolDetails>

}
