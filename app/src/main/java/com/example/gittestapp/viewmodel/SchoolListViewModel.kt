package com.example.gittestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SchoolList
import com.example.domain.repository.SchoolListRepository
import com.example.domain.usecase.SchoolDetailsUseCase
import com.example.domain.usecase.SchoolListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel
@Inject
constructor(
    private val schoolListUseCase: SchoolListUseCase,
    private val schoolDetailsUseCase: SchoolDetailsUseCase
): ViewModel(){



    sealed class SchoolListResponse{
        data class Success(val result: List<SchoolList>)
        object Error: SchoolListResponse()
    }

    suspend fun getSchoolList(){
        viewModelScope.launch {
            try {
                println("School List Response - ${schoolListUseCase.getSchoolList()}")
            } catch (e: Exception) {
                TODO("Not yet implemented")
            }
        }
    }

    suspend fun getSchoolDetails(){
        viewModelScope.launch {
            try {
                println("School Details Response - ${schoolDetailsUseCase.getSchoolDetails()}")
            } catch (e: Exception) {
                TODO("Not yet implemented")
            }
        }
    }

}