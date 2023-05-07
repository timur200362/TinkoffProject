package com.example.tinkoffproject.presentation.FirstPage.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.response.product.Product
import com.example.tinkoffproject.data.response.productInformation.ProductInformationResponse
import com.example.tinkoffproject.presentation.FirstPage.UseCases.GetProductInfoUseCase
import kotlinx.coroutines.launch

class BreakfastSearchViewModel:ViewModel() {
    private val _resultApi = MutableLiveData<List<Product>>()
    val resultApi: LiveData<List<Product>>
        get() = _resultApi

    fun getApi(foodName:String){
        viewModelScope.launch {
            _resultApi.value=GetProductInfoUseCase().execute(foodName)
        }
    }
}