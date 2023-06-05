package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.domain.useCases.GetProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakfastSearchViewModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) : ViewModel() {
    private val _resultApi = MutableLiveData<List<Product>>()
    val resultApi: LiveData<List<Product>>
        get() = _resultApi
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun getApi(foodName: String) {
        viewModelScope.launch {
            try {
                _resultApi.value = getProductListUseCase.execute(foodName)
            }
            catch (throwable: Throwable){
                _error.value="Нет подключения к интернету!"
            }
        }
    }
}