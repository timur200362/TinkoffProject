package com.example.tinkoffproject.presentation.mainPagePackage.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.AppDatabase
import com.example.tinkoffproject.data.database.mealDatabase.Meal
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import com.example.tinkoffproject.presentation.mainPagePackage.mvvm.FoodInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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
            btnAdd.setOnClickListener{ view ->
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
    private fun addToDatabase(){//ToDo сделать по архитектуре
        val db = AppDatabase.getDatabase(requireContext())
        val userDao = db.mealDao()
        lifecycleScope.launch {
            userDao.insert(Meal(title = binding?.tvFoodNameInput?.text.toString(), fat = binding?.tvFatInput?.text.toString(),
                protein = binding?.tvProteinInput?.text.toString(),
                carbohydrates = binding?.tvCarbohydratesInput?.text.toString(),
                calories = binding?.tvCaloriesInput?.text.toString()))
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