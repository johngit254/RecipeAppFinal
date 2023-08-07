package com.example.recipeappfinal.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipeppfinal.databinding.ActivityFoodDetailsBinding

class FoodDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityFoodDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setInitViews()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.btnBack.setOnClickListener()
        {
            onBackPressed()
        }
    }

    private fun setInitViews() {
        var name = intent.getStringExtra("name")
        var type = intent.getStringExtra("type")
        var difficulty = intent.getStringExtra("difficulty")
        var ingredients = intent.getStringExtra("ingredients")
        var noOfPeople = intent.getStringExtra("noOfPeople")?.toInt()
        binding.txtRecipeName.text = name
        binding.txtMealDifficuly.text = "Difficulty: "+difficulty
        binding.txtMealType.text = "Type: "+type
        binding.txtMealIngredients.text = "Ingredients: "+ingredients
        binding.txtNumberOfPeopleServes.text = "No Of People Served: "+noOfPeople.toString()
    }
}