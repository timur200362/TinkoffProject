package com.example.tinkoffproject.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.tinkoffproject.R
import com.example.tinkoffproject.data.dataBase.AppDatabase
import com.example.tinkoffproject.data.dataBase.Meal
import com.example.tinkoffproject.databinding.FragmentTestroomBinding

class TestRoomFragment:Fragment(R.layout.fragment_testroom) {
    private var binding: FragmentTestroomBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTestroomBinding.bind(view)
        binding?.run {
            btnAdd.setOnClickListener{
                val db = Room.databaseBuilder(
                    requireContext(),
                    AppDatabase::class.java, "database-name"
                ).build()

                val userDao = db.mealDao()
                userDao.insert(Meal(foodName=etMealName.text.toString(), calories = etCaloriesCount.text.toString().toDouble()))
            }
        }
    }
}