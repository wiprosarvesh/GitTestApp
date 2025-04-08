package com.example.domain.usecase

import com.example.domain.repository.SchoolDetailsRepository

class SchoolDetailsUseCase(
    private val schoolDetailsRepository: SchoolDetailsRepository
) {

    suspend fun getSchoolDetails() = schoolDetailsRepository.getSchoolDetails()

}
