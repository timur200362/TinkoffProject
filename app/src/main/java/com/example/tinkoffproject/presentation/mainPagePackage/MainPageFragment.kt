package com.example.tinkoffproject.presentation.mainPagePackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentMainpageBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.food.BreakfastSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.food.DinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.food.NightDinnerSearchFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainPageFragment : Fragment(R.layout.fragment_mainpage) {
    private lateinit var viewModel: MainPageViewModel
    private var binding: FragmentMainpageBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainPageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentMainpageBinding.inflate(inflater, container, false).let {
            binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainpageBinding.bind(view)
        binding?.run {
            btnWater.setOnClickListener {
                val water = tvDrunkResult.text.toString()
                val water2 = water.toDouble()
                waterSum(water2)
            }
            tvDate.text = Date().toString()
            addBreakfast()
            addDinner()
            addNightDinner()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.resultMeal.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Protein -> {
                    binding?.tvProteinInput?.text = it.value
                }
                is UIState.Fat -> {
                    binding?.tvFatInput?.text = it.value
                }
                is UIState.Carbohydrates -> {
                    binding?.tvCarbohydrateInput?.text = it.value
                }
                is UIState.Calories -> {
                    binding?.tvCaloriesInput?.text = it.value
                }
            }
        }
        viewModel.getProtein()
        viewModel.getFat()
        viewModel.getCarbohydrates()
        viewModel.getCalories()
        viewModel.resultMealDinner.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Protein -> {
                    binding?.tvProteinDinnerInput?.text = it.value
                }
                is UIState.Fat -> {
                    binding?.tvFatDinnerInput?.text = it.value
                }
                is UIState.Carbohydrates -> {
                    binding?.tvCarbohydrateDinnerInput?.text = it.value
                }
                is UIState.Calories -> {
                    binding?.tvCaloriesDinnerInput?.text = it.value
                }
            }
        }
        viewModel.getProteinDinner()
        viewModel.getFatDinner()
        viewModel.getCarbohydratesDinner()
        viewModel.getCaloriesDinner()
        viewModel.resultMealNightDinner.observe(viewLifecycleOwner) {
            when (it) {
                is UIState.Protein -> {
                    binding?.tvProteinNightDinnerInput?.text = it.value
                }
                is UIState.Fat -> {
                    binding?.tvFatNightDinnerInput?.text = it.value
                }
                is UIState.Carbohydrates -> {
                    binding?.tvCarbohydrateNightDinnerInput?.text = it.value
                }
                is UIState.Calories -> {
                    binding?.tvCaloriesNightDinnerInput?.text = it.value
                }
            }
        }
        viewModel.getProteinNightDinner()
        viewModel.getFatNightDinner()
        viewModel.getCarbohydratesNightDinner()
        viewModel.getCaloriesNightDinner()

    }


    private fun waterSum(waterNumber: Double) {
        binding?.run {
            val water2 = waterNumber + 0.25
            tvDrunkResult.text = "$water2"
        }
    }

    private fun addBreakfast() {
        binding?.run {
            ivAddBreakfast.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        BreakfastSearchFragment.getInstance(bundle),
                        BreakfastSearchFragment.BreakfastSearchFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun addDinner() {
        binding?.run {
            ivAddDinnerDay.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        DinnerSearchFragment.getInstance(bundle),
                        DinnerSearchFragment.DinnerSearchFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    private fun addNightDinner() {
        binding?.run {
            ivAddDinnerEvening.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        NightDinnerSearchFragment.getInstance(bundle),
                        NightDinnerSearchFragment.NightDinnerSearchFragment_TAG
                    )
                    .addToBackStack(null)
                    .commit()
            }
        }
    }


    companion object {
        const val MainPageFragment_TAG = "MainPageFragment_TAG"
        fun getInstance(bundle: Bundle?): MainPageFragment {
            val mainPageFragment = MainPageFragment()
            mainPageFragment.arguments = bundle
            return mainPageFragment
        }
    }
}