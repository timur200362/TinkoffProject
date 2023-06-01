package com.example.tinkoffproject.presentation.statisticsPagePackage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import com.example.tinkoffproject.databinding.FragmentStatisticsBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {
    private lateinit var binding: FragmentStatisticsBinding

    @Inject
    lateinit var mealDatabase: MealDatabase
    private val lineChartXAxisValueFormatter = LineChartXAxisValueFormatter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentStatisticsBinding.bind(view)
        binding.run {
            lifecycleScope.launch {
                val meals = mealDatabase.mealDao().getAll()
                val entries = meals.map { meal ->
                    Entry(meal.date.time.toFloat(), meal.calories.toFloat())
                }
                chartBreakfast.data = LineData(LineDataSet(entries, "Калории"))
                chartBreakfast.invalidate()

                val mealsDinner = mealDatabase.mealDao().getAllDinner()
                val entriesDinner = mealsDinner.map { meal ->
                    Entry(meal.date.time.toFloat(), meal.calories.toFloat())
                }
                chartDinner.data = LineData(LineDataSet(entriesDinner, "Калории"))
                chartDinner.invalidate()

                val mealsNightDinner = mealDatabase.mealDao().getAllNightDinner()
                val entriesNightDinner = mealsNightDinner.map { meal ->
                    Entry(meal.date.time.toFloat(), meal.calories.toFloat())
                }
                chartNightDinner.data = LineData(LineDataSet(entriesNightDinner, "Калории"))
                chartNightDinner.invalidate()
            }
        }
        val spinner: Spinner = binding.graphicsSpinner
        context?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.graphics_array,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                // Specify the layout to use when the list of choices appears
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                // Apply the adapter to the spinner
                spinner.adapter = adapter
            }
        }
    }
}