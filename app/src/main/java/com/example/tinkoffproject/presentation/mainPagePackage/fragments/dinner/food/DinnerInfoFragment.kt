package com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.food

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.response.productInformation.ProductFilter
import com.example.tinkoffproject.databinding.FragmentDinnerinfoBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.mvvm.DinnerInfoViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class DinnerInfoFragment : Fragment(R.layout.fragment_dinnerinfo) {
    private lateinit var viewModel: DinnerInfoViewModel
    private lateinit var binding: FragmentDinnerinfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DinnerInfoViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDinnerinfoBinding.bind(view)
        arguments?.getInt("foodId")?.let { loadTitle(it) }
        viewModel.resultApi.observe(viewLifecycleOwner) {
            showNutrition(it)
        }
        binding.run {
            btnAdd.setOnClickListener { _ ->
                addToDatabase()
            }
            btnMakeFavourite.setOnClickListener {
                addFavourite()
            }
        }
        viewModel.error.observe(viewLifecycleOwner){
            Toast.makeText(context,it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadTitle(foodId: Int) {
        viewModel.getProductInfo(foodId)
    }

    private fun showNutrition(nutrition: ProductFilter) {
        binding.run {
            tvId.text = nutrition.id.toString()
            tvFoodNameInput.text = nutrition.title
            tvCalciumInput.text = nutrition.calcium
            tvCholesterolInput.text = nutrition.cholesterol
            tvFatInput.text = nutrition.fat
            tvProteinInput.text = nutrition.protein
            tvCarbohydratesInput.text = nutrition.carbohydrates
            tvCaloriesInput.text = nutrition.calories
            tvSugarInput.text = nutrition.sugar
            tvBadgesInput.text = nutrition.importantBadges.toString()
            tvIngredientsInput.text = nutrition.ingredientList
        }
    }

    private fun addToDatabase() {
        binding.run {
            viewModel.insert(
                foodId = tvId.text.toString().toDouble(),
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
        }
    }

    private fun addFavourite() {
        binding.run {
            viewModel.updateFavourite(isFavourite = true, tvId.text.toString().toDouble())
        }
    }

    companion object {
        const val DinnerInfoFragment_TAG = "DinnerInfoFragment_TAG"
        fun getInstance(bundle: Bundle?): DinnerInfoFragment {
            val dinnerInfoFragment = DinnerInfoFragment()
            dinnerInfoFragment.arguments = bundle
            return dinnerInfoFragment
        }
    }
}