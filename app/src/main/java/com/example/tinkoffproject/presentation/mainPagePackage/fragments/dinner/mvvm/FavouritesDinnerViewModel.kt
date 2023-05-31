package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.database.mealDatabase.MealDinner
import com.example.tinkoffproject.domain.useCases.breakfast.GetFavouriteMealBreakfastUseCase
import com.example.tinkoffproject.domain.useCases.dinner.GetFavouriteMealDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesDinnerViewModel @Inject constructor(
    private val getFavouriteMealDinnerUseCase: GetFavouriteMealDinnerUseCase
) : ViewModel() {
    private val _resultFavourite = MutableLiveData<List<MealDinner>>()
    val resultFavourite: LiveData<List<MealDinner>>
        get() = _resultFavourite

    fun fetchFavourite() {
        viewModelScope.launch {
            _resultFavourite.value = getFavouriteMealDinnerUseCase.execute()
        }
    }
}