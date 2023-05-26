package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.GetProductTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodInfoViewModel @Inject constructor(
    private val getProductTitleUseCase: GetProductTitleUseCase,
) : ViewModel() {
    private val _resultApi = MutableLiveData<ProductFilter>()
    val resultApi: LiveData<ProductFilter>
        get() = _resultApi

    fun getProductInfo(foodId: Int) {
        viewModelScope.launch {
            _resultApi.value = getProductTitleUseCase.execute(foodId)
        }
    }
}