package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.GetProductInfoUseCase
import com.example.tinkoffproject.domain.useCases.nightDinner.AddMealNightDinnerUseCase
import com.example.tinkoffproject.domain.useCases.nightDinner.UpdateFavouriteMealNightDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class NightDinnerInfoViewModel @Inject constructor(
    private val getProductInfoUseCase: GetProductInfoUseCase,
    private val addMealNightDinnerUseCase: AddMealNightDinnerUseCase,
    private val updateFavouriteMealNightDinnerUseCase: UpdateFavouriteMealNightDinnerUseCase
) : ViewModel() {
    private val _resultApi = MutableLiveData<ProductFilter>()
    val resultApi: LiveData<ProductFilter>
        get() = _resultApi
    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    fun getProductInfo(foodId: Int) {
        viewModelScope.launch {
            try {
                _resultApi.value = getProductInfoUseCase.execute(foodId)
            }
            catch (throwable: Throwable){
                _error.value="Нет подключения к интернету!"
            }
        }
    }

    fun updateFavourite(isFavourite: Boolean, id: Double) {
        viewModelScope.launch {
            updateFavouriteMealNightDinnerUseCase.execute(isFavourite, id)
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
            addMealNightDinnerUseCase.execute(
                mealNightDinner = MealNightDinner(
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