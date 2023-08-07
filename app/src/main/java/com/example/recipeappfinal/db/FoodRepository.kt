package com.example.recipeappfinal.db

import androidx.lifecycle.LiveData
import com.example.recipeappfinal.models.FoodModel

class FoodRepository(private val itemDao: FoodDao) {
    suspend fun insertItems(items: List<FoodModel>) {
        itemDao.insertAll(items)
    }

    fun getAllItems(): LiveData<List<FoodModel>> {
        return itemDao.getAllItems()
    }
    fun getFoodByType(type: String): LiveData<List<FoodModel>> {
        return itemDao.getFoodByType(type)
    }
}
