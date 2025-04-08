package com.example.data.module

import com.example.data.api.ApiService
import com.example.data.mapper.SchoolDetailsMapper
import com.example.data.mapper.SchoolListMapper
import com.example.data.network.RetrofitService
import com.example.data.repository.SchoolDetailsRepositoryImpl
import com.example.data.repository.SchoolListRepositoryImpl
import com.example.domain.repository.SchoolDetailsRepository
import com.example.domain.repository.SchoolListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideSchoolListRepository(
        retrofitService: RetrofitService,
        schoolListMapper: SchoolListMapper
    ): SchoolListRepository {
        return SchoolListRepositoryImpl(retrofitService, schoolListMapper)
    }

    @Singleton
    @Provides
    fun provideSchoolDetailsRepository(
        retrofitService: RetrofitService,
        schoolDetailsMapper: SchoolDetailsMapper
    ): SchoolDetailsRepository {
        return SchoolDetailsRepositoryImpl(retrofitService, schoolDetailsMapper)
    }

}
