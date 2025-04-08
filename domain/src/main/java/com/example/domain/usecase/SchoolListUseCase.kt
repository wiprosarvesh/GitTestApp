package com.example.domain.usecase

import com.example.domain.repository.SchoolListRepository

class SchoolListUseCase(
    private val schoolListRepository: SchoolListRepository,
) {

    suspend fun getSchoolList() = schoolListRepository.getSchoolList()

}
