package com.example.tinkoffproject.data.dataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Meal (
    @PrimaryKey(autoGenerate = true) val uid: Int=0,
    val foodName:String,
    val calories:Double,
    //val Date:Date
    )