package com.example.tinkoffproject.presentation.mainPagePackage.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.domain.useCases.GetProductTitleUseCase
import com.example.tinkoffproject.domain.useCases.ProductFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodInfoViewModel @Inject constructor(
    private val getProductTitleUseCase: GetProductTitleUseCase
) : ViewModel() {
    private val _resultApiTitle = MutableLiveData<ProductFilter>()
    val resultApiTitle: LiveData<ProductFilter>
        get() = _resultApiTitle

    fun getTitle(foodId:Int) {
        viewModelScope.launch {
            _resultApiTitle.value = getProductTitleUseCase.execute(foodId)
        }
    }
}