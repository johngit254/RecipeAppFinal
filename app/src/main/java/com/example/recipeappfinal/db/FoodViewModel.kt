package com.example.recipeappfinal.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.recipeappfinal.models.FoodModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodViewModel( application: Application) : AndroidViewModel(application) {

    val repository: FoodRepository
    var allFoods: LiveData<List<FoodModel>>
    // initialize dao, repository and all events
    init {
        val dao = FoodDatabase.getInstance(application).itemDao()
        repository = FoodRepository(dao)
        allFoods = repository.getAllItems()
    }

    fun insertItems(items: List<FoodModel>) {
        viewModelScope.launch(Dispatchers.IO) { repository.insertItems(items)}
    }
    fun getFoodItems(type: String):LiveData<List<FoodModel>>
    {
        return repository.getFoodByType(type)
    }
}
