package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.breakfast.GetAllMealBreakfastUseCase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val getAllMealBreakfastUseCase: GetAllMealBreakfastUseCase
):ViewModel() {
    private val _resultMeal = MutableLiveData<UIState>()
    val resultMeal: LiveData<UIState>
        get() = _resultMeal

    fun getProtein(){
        viewModelScope.launch {
            _resultMeal.value=UIState.Protein(getAllMealBreakfastUseCase.executeProtein())
        }
    }
//    fun getFat(){
//        viewModelScope.launch {
//            _resultMeal.value=getAllMealBreakfastUseCase.executeFat()
//        }
//    }
//    fun getCarbohydrates(){
//        viewModelScope.launch {
//            _resultMeal.value=getAllMealBreakfastUseCase.executeCarbohydrates()
//        }
//    }
//    fun getCalories(){
//        viewModelScope.launch {
//            _resultMeal.value=getAllMealBreakfastUseCase.executeFat()
//        }
//    }
}

sealed interface UIState{
    class Protein(
        val value:String
    ):UIState
    class Fat(
        val value:String
    ):UIState
}