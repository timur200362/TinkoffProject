package com.example.tinkoffproject.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meal (
    @PrimaryKey(autoGenerate = true) val uid: Int=0,
    val foodName:String,
    val calories:Double,
    //val Date:Date
    )