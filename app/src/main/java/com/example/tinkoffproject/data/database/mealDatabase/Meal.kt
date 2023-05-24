package com.example.tinkoffproject.data.database.mealDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Meal(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "fat") val fat: String,
    @ColumnInfo(name = "protein") val protein: String,
    @ColumnInfo(name = "carbohydrates") val carbohydrates: String,
    @ColumnInfo(name = "calories") val calories: String,
    //@ColumnInfo(name="date") val date: Date
)