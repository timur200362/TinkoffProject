package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.domain.useCases.breakfast.GetFavouriteByIdMealBreakfastUseCase
import com.example.tinkoffproject.domain.useCases.dinner.GetFavouriteByIdMealDinnerUseCase
import com.example.tinkoffproject.domain.useCases.dinner.GetFavouriteMealDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteInfoDinnerViewModel @Inject constructor(
    private val getFavouriteByIdMealDinnerUseCase: GetFavouriteByIdMealDinnerUseCase
):ViewModel() {
    private val _resultFavourite = MutableLiveData<MealDinner>()
    val resultFavourite: LiveData<MealDinner>
        get() = _resultFavourite
    fun fetchFavouriteInfoById(id:Double){
        viewModelScope.launch {
            _resultFavourite.value=getFavouriteByIdMealDinnerUseCase.execute(id)
        }
    }
}