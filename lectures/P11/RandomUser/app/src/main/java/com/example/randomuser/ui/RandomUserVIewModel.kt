package com.example.randomuser.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuser.model.RandomUser
import com.example.randomuser.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class RandomUserUiState (
    val isLoading: Boolean = false,
    val users: List<RandomUser> = emptyList(),
    val errorMessage: String? = null
)

class RandomUserVIewModel : ViewModel(){

    private val apiKey = "2R4Hbl8uF12ySyHdrj5GZA==wLTqCc8JrdzGcPOD"

    private val _uiState = MutableStateFlow(RandomUserUiState())
    val uiState: StateFlow<RandomUserUiState> = _uiState

    fun loadRandomUsers(count: Int = 2){
        _uiState.value = _uiState.value.copy(
            isLoading = true,
            errorMessage = null
        )

        viewModelScope.launch {
            try {
                val users = RetrofitClient.api.getRandomUsers(
                    apiKey = apiKey,
                    count = count
                )
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    users,
                    errorMessage = null
                )
            }catch (e: Exception){
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    errorMessage = "Greška: ${e.message}"
                )
            }
        }
    }
}