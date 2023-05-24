package com.example.tinkoffproject.data.database.mealDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkoffproject.presentation.Converter
import java.time.LocalDate
import java.util.*

@TypeConverters(Converter::class)
@Entity()
data class MealBreakfast(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "fat") val fat: Double,
    @ColumnInfo(name = "protein") val protein: Double,
    @ColumnInfo(name = "carbohydrates") val carbohydrates: Double,
    @ColumnInfo(name = "calories") val calories: Double,
    @ColumnInfo(name = "date") val date: Date
)