package com.example.navigationexample2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ExViewModel: ViewModel() {

    private var _uiState = mutableStateOf(ExUIState())
    val uiState: ExUIState get() = _uiState.value

    fun updateName(newName: String){
        _uiState.value = _uiState.value.copy(
            name = newName
        )
    }
}


