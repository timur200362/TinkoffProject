package com.example.tinkoffproject.presentation.mainPagePackage.fragments.breakfast

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.databinding.FragmentMainpageBinding
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.dinner.DinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.nightdinner.NightDinnerSearchFragment
import com.example.tinkoffproject.presentation.mainPagePackage.fragments.snacks.SnacksSearchFragment
import kotlinx.coroutines.launch
import java.util.*

class MainPageFragment : Fragment(R.layout.fragment_mainpage) {

    private var binding: FragmentMainpageBinding? = null

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
        getFromDatabase()
    }

    private fun getFromDatabase() {//ToDo сделать по архитектуре
        val db = MealDatabase.getDatabase(requireContext())
        val userDao = db.mealDao()
        lifecycleScope.launch {
            binding?.run {
                tvProteinInput.text = userDao.getAll().sumOf { it.protein }.toString()
                tvFatInput.text = userDao.getAll().sumOf { it.fat }.toString()
                tvCarbohydrateInput.text = userDao.getAll().sumOf { it.carbohydrates }.toString()
                tvCaloriesInput.text = userDao.getAll().sumOf { it.calories }.toString()
            }
        }
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