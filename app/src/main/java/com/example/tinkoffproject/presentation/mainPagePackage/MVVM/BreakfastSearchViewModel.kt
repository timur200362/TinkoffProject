package com.example.tinkoffproject.presentation.mainPagePackage.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.domain.UseCases.GetProductInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreakfastSearchViewModel @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase
    ):ViewModel() {
    private val _resultApi = MutableLiveData<List<Product>>()
    val resultApi: LiveData<List<Product>>
        get() = _resultApi

    fun getApi(foodName:String){
        viewModelScope.launch {
            _resultApi.value=getProductInfoUseCase.execute(foodName)
        }
    }
}