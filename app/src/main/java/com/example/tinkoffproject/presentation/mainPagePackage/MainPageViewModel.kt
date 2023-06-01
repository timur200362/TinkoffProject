package com.example.tinkoffproject.presentation.mainPagePackage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffproject.domain.useCases.breakfast.GetAllMealBreakfastUseCase
import com.example.tinkoffproject.domain.useCases.dinner.GetAllMealDinnerUseCase
import com.example.tinkoffproject.domain.useCases.nightDinner.GetAllMealNightDinnerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor(
    private val getAllMealBreakfastUseCase:GetAllMealBreakfastUseCase,
    private val getAllMealDinnerUseCase: GetAllMealDinnerUseCase,
    private val getAllMealNightDinnerUseCase: GetAllMealNightDinnerUseCase,
) : ViewModel() {

    private val _resultMeal = MutableLiveData<UIState>()
    val resultMeal: LiveData<UIState>
        get() = _resultMeal

    private val _resultMealDinner = MutableLiveData<UIState>()
    val resultMealDinner: LiveData<UIState>
        get() = _resultMealDinner

    private val _resultMealNightDinner = MutableLiveData<UIState>()
    val resultMealNightDinner: LiveData<UIState>
        get() = _resultMealNightDinner

    fun getProtein() {
        viewModelScope.launch {
            _resultMeal.value = UIState.Protein(getAllMealBreakfastUseCase.executeProtein())
        }
    }

    fun getFat() {
        viewModelScope.launch {
            _resultMeal.value = UIState.Fat(getAllMealBreakfastUseCase.executeFat())
        }
    }

    fun getCarbohydrates() {
        viewModelScope.launch {
            _resultMeal.value =
                UIState.Carbohydrates(getAllMealBreakfastUseCase.executeCarbohydrates())
        }
    }

    fun getCalories() {
        viewModelScope.launch {
            _resultMeal.value = UIState.Calories(getAllMealBreakfastUseCase.executeCalories())
        }
    }

    fun getProteinDinner() {
        viewModelScope.launch {
            _resultMealDinner.value = UIState.Protein(getAllMealDinnerUseCase.executeProtein())
        }
    }

    fun getFatDinner() {
        viewModelScope.launch {
            _resultMealDinner.value = UIState.Fat(getAllMealDinnerUseCase.executeFat())
        }
    }

    fun getCarbohydratesDinner() {
        viewModelScope.launch {
            _resultMealDinner.value =
                UIState.Carbohydrates(getAllMealDinnerUseCase.executeCarbohydrates())
        }
    }

    fun getCaloriesDinner() {
        viewModelScope.launch {
            _resultMealDinner.value = UIState.Calories(getAllMealDinnerUseCase.executeCalories())
        }
    }

    fun getProteinNightDinner() {
        viewModelScope.launch {
            _resultMealNightDinner.value = UIState.Protein(getAllMealNightDinnerUseCase.executeProtein())
        }
    }

    fun getFatNightDinner() {
        viewModelScope.launch {
            _resultMealNightDinner.value = UIState.Fat(getAllMealNightDinnerUseCase.executeFat())
        }
    }

    fun getCarbohydratesNightDinner() {
        viewModelScope.launch {
            _resultMealNightDinner.value =
                UIState.Carbohydrates(getAllMealNightDinnerUseCase.executeCarbohydrates())
        }
    }

    fun getCaloriesNightDinner() {
        viewModelScope.launch {
            _resultMealNightDinner.value = UIState.Calories(getAllMealNightDinnerUseCase.executeCalories())
        }
    }
}