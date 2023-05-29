package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.breakfast.AddMealBreakfastUseCase
import com.example.tinkoffproject.domain.useCases.GetProductInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class FoodInfoViewModel @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase,
    private val addMealBreakfastUseCase: AddMealBreakfastUseCase
) : ViewModel() {
    private val _resultApi = MutableLiveData<ProductFilter>()
    val resultApi: LiveData<ProductFilter>
        get() = _resultApi

    fun getProductInfo(foodId: Int) {
        viewModelScope.launch {
            _resultApi.value = getProductInfoUseCase.execute(foodId)
        }
    }
    fun insert(
        foodId: Double,
        title: String,
        fat: Double,
        protein: Double,
        carbohydrates: Double,
        calories: Double,
        calcium: Double,
        cholesterol: Double,
        sugar: Double,
        importantBadges: String,
        ingredients: String,
        date: Date,
        isFavourite:Boolean
    ) {
        viewModelScope.launch {
            addMealBreakfastUseCase.execute(
                mealBreakfast = MealBreakfast(
                    foodId,
                    title,
                    fat,
                    protein,
                    carbohydrates,
                    calories,
                    date,
                    isFavourite,
                    calcium,
                    cholesterol,
                    sugar,
                    importantBadges,
                    ingredients,
                )
            )
        }
    }
}