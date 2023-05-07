package com.example.tinkoffproject.presentation.FirstPage.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BreakfastSearchViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BreakfastSearchViewModel() as T
    }
}