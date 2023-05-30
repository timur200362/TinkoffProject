package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.domain.useCases.breakfast.GetFavouriteByIdMealBreakfastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteInfoViewModel @Inject constructor(
    private val getFavouriteByIdMealBreakfastUseCase: GetFavouriteByIdMealBreakfastUseCase
):ViewModel() {
    private val _resultFavourite = MutableLiveData<MealBreakfast>()
    val resultFavourite: LiveData<MealBreakfast>
        get() = _resultFavourite
    fun fetchFavouriteInfoById(id:Double){
        viewModelScope.launch {
            _resultFavourite.value=getFavouriteByIdMealBreakfastUseCase.execute(id)
        }
    }
}