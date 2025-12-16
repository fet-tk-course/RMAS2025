package com.example.buttonsviewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    var count by mutableStateOf(0)

    fun increment(){
        count++
    }

    fun decrement(){
        count--
    }
}