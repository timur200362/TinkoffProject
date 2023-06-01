package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.domain.useCases.nightDinner.GetFavouriteByIdMealNightDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteInfoNightDinnerViewModel @Inject constructor(
    private val getFavouriteByIdMealNightDinnerUseCase: GetFavouriteByIdMealNightDinnerUseCase
) : ViewModel() {
    private val _resultFavourite = MutableLiveData<MealNightDinner>()
    val resultFavourite: LiveData<MealNightDinner>
        get() = _resultFavourite

    fun fetchFavouriteInfoById(id: Double) {
        viewModelScope.launch {
            _resultFavourite.value = getFavouriteByIdMealNightDinnerUseCase.execute(id)
        }
    }
}