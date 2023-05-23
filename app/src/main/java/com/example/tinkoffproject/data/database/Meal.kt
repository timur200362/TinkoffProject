package com.example.tinkoffproject.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity()
data class Meal (
    @PrimaryKey(autoGenerate = true) val uid: Int=0,
    @ColumnInfo(name="food_name") val foodName:String,
    @ColumnInfo(name="calories") val calories:Double,
    @ColumnInfo(name="date") val date: Date,
    )