package com.example.tinkoffproject.presentation.mainPagePackage.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.response.productInformation.Nutrition
import com.example.tinkoffproject.databinding.FragmentFoodinfoBinding
import com.example.tinkoffproject.domain.UseCases.NutritionResponse
import com.example.tinkoffproject.presentation.mainPagePackage.MVVM.FoodInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FoodInfoFragment : Fragment(R.layout.fragment_foodinfo) {
    private lateinit var viewModel:FoodInfoViewModel
    private var binding:FragmentFoodinfoBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this)[FoodInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFoodinfoBinding.bind(view)
        arguments?.getInt("foodId")?.let { loadTitle(it) }
        viewModel.resultApiTitle.observe(viewLifecycleOwner){
            showTitle(it.title)
            showNutrition(it.nutrition)
            showImportantBadges(it.importantBadges)
            showIngredientList(it.ingredientList)
        }
    }

    private fun loadTitle(foodId:Int){
        viewModel.getTitle(foodId)
    }
    private fun showTitle(title: String) {
        binding?.tvFoodNameInput?.run {
            text = title
        }
    }
    private fun showNutrition(nutrition: NutritionResponse){
        binding?.run {
            tvCalciumInput.text= nutrition.nutrients.toString()
//            tvCholesterolInput.text= nutrition.nutrients.toString()
//            tvFatInput.text= nutrition.nutrients.toString()
//            tvProteinInput.text= nutrition.nutrients.toString()
//            tvCarbohydratesInput.text= nutrition.nutrients.toString()
//            tvCaloriesInput.text= nutrition.nutrients.toString()
//            tvSugarInput.text= nutrition.nutrients.toString()
        }
    }
    private fun showImportantBadges(importantBadges:List<String>){
        binding?.tvBadgesInput?.text=importantBadges.toString()
    }
    private fun showIngredientList(ingredientList:String){
        binding?.tvIngredientsInput?.text=ingredientList
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