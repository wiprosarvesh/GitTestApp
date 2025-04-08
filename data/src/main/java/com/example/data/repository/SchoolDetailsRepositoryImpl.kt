package com.example.data.repository

import com.example.data.api.ApiService
import com.example.data.mapper.SchoolDetailsMapper
import com.example.data.network.RetrofitService
import com.example.domain.model.SchoolDetails
import com.example.domain.repository.SchoolDetailsRepository

class SchoolDetailsRepositoryImpl
constructor(
    private val retrofitService: RetrofitService,
    private val schoolDetailsMapper: SchoolDetailsMapper
) : SchoolDetailsRepository {

    override suspend fun getSchoolDetails(): List<SchoolDetails> {
        return schoolDetailsMapper.mapFromEntityList(
            retrofitService.getInstance().create(ApiService::class.java).getSchoolDetails()
        )
    }

}
