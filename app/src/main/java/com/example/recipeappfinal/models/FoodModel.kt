package com.example.recipeappfinal.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class FoodModel(@PrimaryKey(autoGenerate = true) val id: Int = 0, val name: String="", val type:String="", var difficulty: String="", val ingredients: String="", val noOfPeople: Int=0)
