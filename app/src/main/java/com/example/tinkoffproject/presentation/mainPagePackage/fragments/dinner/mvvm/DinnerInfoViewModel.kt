package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.GetProductInfoUseCase
import com.example.tinkoffproject.domain.useCases.dinner.AddMealDinnerUseCase
import com.example.tinkoffproject.domain.useCases.dinner.UpdateFavouriteMealDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class DinnerInfoViewModel @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase,
    private val addMealDinnerUseCase: AddMealDinnerUseCase,
    private val updateFavouriteMealDinnerUseCase: UpdateFavouriteMealDinnerUseCase
) : ViewModel() {
    private val _resultApi = MutableLiveData<ProductFilter>()
    val resultApi: LiveData<ProductFilter>
        get() = _resultApi

    fun getProductInfo(foodId: Int) {
        viewModelScope.launch {
            _resultApi.value = getProductInfoUseCase.execute(foodId)
        }
    }

    fun updateFavourite(isFavourite: Boolean, id: Double) {
        viewModelScope.launch {
            updateFavouriteMealDinnerUseCase.execute(isFavourite, id)
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
        isFavourite: Boolean
    ) {
        viewModelScope.launch {
            addMealDinnerUseCase.execute(
                mealDinner = MealDinner(
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