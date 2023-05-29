package com.example.tinkoffproject

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.tinkoffproject.data.database.mealDatabase.MealDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application()