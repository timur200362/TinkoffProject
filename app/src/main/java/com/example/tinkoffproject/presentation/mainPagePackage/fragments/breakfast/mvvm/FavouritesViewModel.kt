package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.domain.useCases.breakfast.GetFavouriteMealBreakfastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val getFavouriteMealBreakfastUseCase: GetFavouriteMealBreakfastUseCase
):ViewModel() {
    private val _resultFavourite = MutableLiveData<List<MealBreakfast>>()
    val resultFavourite: LiveData<List<MealBreakfast>>
        get() = _resultFavourite
    fun getFavourite():List<MealBreakfast> {
        viewModelScope.launch {
            _resultFavourite.value=getFavouriteMealBreakfastUseCase.execute()
        }
    }
}