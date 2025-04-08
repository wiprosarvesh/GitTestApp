package com.example.gittestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SchoolList
import com.example.domain.usecase.SchoolListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolListViewModel
@Inject
constructor(
    private val schoolListUseCase: SchoolListUseCase
) : ViewModel() {


    // Backing property to avoid state updates from other classes
    private val _uiState: MutableStateFlow<SchoolListResponseState> =
        MutableStateFlow(SchoolListResponseState.None)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<SchoolListResponseState> = _uiState

    sealed class SchoolListResponseState {
        data class Success(val result: List<SchoolList>) : SchoolListResponseState()
        object Error : SchoolListResponseState()
        object None : SchoolListResponseState()
    }

    suspend fun getSchoolList() {
        viewModelScope.launch {
            try {
                _uiState.value = if (schoolListUseCase.getSchoolList().isNotEmpty())
                    SchoolListResponseState.Success(schoolListUseCase.getSchoolList())
                else
                    SchoolListResponseState.Error
                println("School List Response - ${schoolListUseCase.getSchoolList()}")
            } catch (e: Exception) {
                _uiState.value = SchoolListResponseState.Error
            }
        }
    }

}
