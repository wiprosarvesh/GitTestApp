package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.SchoolListMapper
import com.example.data.network.RetrofitService
import com.example.domain.model.SchoolList
import com.example.domain.repository.SchoolListRepository

class SchoolListRepositoryImpl
constructor(
    private val retrofitService: RetrofitService,
    private val schoolListMapper: SchoolListMapper
) : SchoolListRepository {
    override suspend fun getSchoolList(): List<SchoolList> {
        return schoolListMapper.mapFromEntityList(
            retrofitService.getInstance().create(ApiService::class.java).getSchoolList()
        )
    }

}
