package com.example.tinkoffproject.presentation.mainPagePackage.mvvm

import androidx.lifecycle.*
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.domain.useCases.GetProductTitleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodInfoViewModel @Inject constructor(
    private val getProductTitleUseCase: GetProductTitleUseCase,
    //private val addToDatabaseUseCase: AddToDatabaseUseCase,
    //private val context: Context
) : ViewModel() {
    private val _resultApi = MutableLiveData<ProductFilter>()
    val resultApi: LiveData<ProductFilter>
        get() = _resultApi

    fun getProductInfo(foodId: Int) {
        viewModelScope.launch {
            _resultApi.value = getProductTitleUseCase.execute(foodId)
        }
    }
//    fun addToDatabase(){
//        val db = AppDatabase.getDatabase(context)
//        val userDao = db.mealDao()
//        viewModelScope.launch {
//            userDao.insert(addToDatabaseUseCase.execute())
//        }
//    }
}