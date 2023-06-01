package com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealNightDinner
import com.example.tinkoffproject.domain.useCases.nightDinner.GetFavouriteMealNightDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesNightDinnerViewModel @Inject constructor(
    private val getFavouriteMealNightDinnerUseCase: GetFavouriteMealNightDinnerUseCase
) : ViewModel() {
    private val _resultFavourite = MutableLiveData<List<MealNightDinner>>()
    val resultFavourite: LiveData<List<MealNightDinner>>
        get() = _resultFavourite

    fun fetchFavourite() {
        viewModelScope.launch {
            _resultFavourite.value = getFavouriteMealNightDinnerUseCase.execute()
        }
    }
}