package com.example.tinkoffproject.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.database.AppDatabase
import com.example.tinkoffproject.data.database.Meal
import com.example.tinkoffproject.databinding.FragmentTestroomBinding
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.util.*

class TestRoomFragment:Fragment(R.layout.fragment_testroom) {
    private var binding: FragmentTestroomBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTestroomBinding.bind(view)
        binding?.run {
            btnAdd.setOnClickListener{
                val db = AppDatabase.getDatabase(requireActivity())

                val userDao = db.mealDao()
                lifecycleScope.launch {
                    userDao.insert(Meal(foodName=etMealName.text.toString(), calories = etCaloriesCount.text.toString().toDouble(), date = Date()))
                }
            }
        }
    }
}