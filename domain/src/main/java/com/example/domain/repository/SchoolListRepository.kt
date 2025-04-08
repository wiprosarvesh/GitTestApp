package com.example.domain.repository

import com.example.domain.model.SchoolList

interface SchoolListRepository {

    suspend fun getSchoolList(): List<SchoolList>

}
