package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.databinding.FragmentMainpageBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast.mvvm.MainPageViewModel
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.DinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.NightDinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.snacks.SnacksSearchFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
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
        // Inflate the layout for this fragment
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
            addSnacks()
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
                    binding?.tvCalories?.text = it.value
                }
            }
        }
        viewModel.getProtein()
        viewModel.getFat()
        viewModel.getCarbohydrates()
        viewModel.getCalories()
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
                    .addToBackStack(MainPageFragment_TAG)
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
                    .addToBackStack(MainPageFragment_TAG)
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
                    .addToBackStack(MainPageFragment_TAG)
                    .commit()
            }
        }
    }

    private fun addSnacks() {
        binding?.run {
            ivAddSnack.setOnClickListener {
                val bundle = Bundle()
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(
                        R.id.container,
                        SnacksSearchFragment.getInstance(bundle),
                        SnacksSearchFragment.SnacksSearchFragment_TAG
                    )
                    .addToBackStack(MainPageFragment_TAG)
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