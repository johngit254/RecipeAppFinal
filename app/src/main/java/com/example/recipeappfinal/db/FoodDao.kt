package com.example.recipeappfinal.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.recipeappfinal.models.FoodModel

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<FoodModel>)

    @Query("SELECT * FROM food_table")
    fun getAllItems(): LiveData<List<FoodModel>>

    @Query("SELECT * FROM food_table where type = :type")
    fun getFoodByType(type: String): LiveData<List<FoodModel>>
}
