package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealBreakfast
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.FoodInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class FoodInfoFragment : Fragment(R.layout.fragment_foodinfo) {
    private lateinit var viewModel: FoodInfoViewModel
    private var binding: FragmentFoodinfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FoodInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
        arguments?.getInt("foodId")?.let { loadTitle(it) }
        viewModel.resultApi.observe(viewLifecycleOwner) {
            showTitle(it.title)
            showNutrition(it)
            showImportantBadges(it.importantBadges)
            showIngredientList(it.ingredientList)
        }
        binding?.run {
            btnAdd.setOnClickListener { view ->
                addToDatabase()
            }
        }
    }

    private fun loadTitle(foodId: Int) {
        viewModel.getProductInfo(foodId)
    }

    private fun showTitle(title: String) {
        binding?.tvFoodNameInput?.run {
            text = title
        }
    }

    private fun showNutrition(nutrition: ProductFilter) {
        binding?.run {
            tvCalciumInput.text = nutrition.calcium
            tvCholesterolInput.text = nutrition.cholesterol
            tvFatInput.text = nutrition.fat
            tvProteinInput.text = nutrition.protein
            tvCarbohydratesInput.text = nutrition.carbohydrates
            tvCaloriesInput.text = nutrition.calories
            tvSugarInput.text = nutrition.sugar
        }
    }

    private fun showImportantBadges(importantBadges: List<String>) {
        binding?.tvBadgesInput?.text = importantBadges.toString()
    }

    private fun showIngredientList(ingredientList: String) {
        binding?.tvIngredientsInput?.text = ingredientList
    }

    private fun addToDatabase() {//ToDo сделать по архитектуре
        val db = MealDatabase.getDatabase(requireContext())
        val userDao = db.mealDao()
        lifecycleScope.launch {
            binding?.run {
                userDao.insert(
                    MealBreakfast(
                        title = tvFoodNameInput.text.toString(),
                        fat = tvFatInput.text.toString().toDouble(),
                        protein = tvProteinInput.text.toString().toDouble(),
                        carbohydrates = tvCarbohydratesInput.text.toString().toDouble(),
                        calories = tvCaloriesInput.text.toString().toDouble(), date = Date(),
                        calcium = tvCalciumInput.text.toString().toDouble(),
                        cholesterol = tvCholesterolInput.text.toString().toDouble(),
                        sugar = tvSugarInput.text.toString().toDouble(),
                        importantBadges = tvBadgesInput.text.toString(),
                        ingredients = tvIngredientsInput.text.toString(),
                        isFavourite = false
                    )
                )
            }
        }
    }

    companion object {
        const val FoodInfoFragment_TAG = "FoodInfoFragment_TAG"
        fun getInstance(bundle: Bundle?): FoodInfoFragment {
            val foodInfoFragment = FoodInfoFragment()
            foodInfoFragment.arguments = bundle
            return foodInfoFragment
        }
    }
}