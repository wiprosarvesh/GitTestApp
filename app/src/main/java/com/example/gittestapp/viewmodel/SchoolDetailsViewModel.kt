package com.example.gittestapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.SchoolDetails
import com.example.domain.usecase.SchoolDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolDetailsViewModel
@Inject
constructor(
    private val schoolDetailsUseCase: SchoolDetailsUseCase
) : ViewModel() {

    // Backing property to avoid state updates from other classes
    private val _uiState: MutableStateFlow<SchoolDetailsResponseState> =
        MutableStateFlow(SchoolDetailsResponseState.None)

    // The UI collects from this StateFlow to get its state updates
    val uiState: StateFlow<SchoolDetailsResponseState> = _uiState

    sealed class SchoolDetailsResponseState {
        data class Success(val result: SchoolDetails?) : SchoolDetailsResponseState()
        object Error : SchoolDetailsResponseState()
        object None : SchoolDetailsResponseState()
    }

    suspend fun getSchoolDetails(schoolId: Int) {
        viewModelScope.launch {
            try {
                _uiState.value = if (schoolDetailsUseCase.getSchoolDetails().isNotEmpty())
                    SchoolDetailsResponseState.Success(schoolDetailsUseCase.getSchoolDetails().firstOrNull { it.schoolId == schoolId })
                else
                    SchoolDetailsResponseState.Error
                println("School Details Response - ${schoolDetailsUseCase.getSchoolDetails()}")
            } catch (e: Exception) {
                _uiState.value = SchoolDetailsResponseState.Error
            }
        }
    }

}
