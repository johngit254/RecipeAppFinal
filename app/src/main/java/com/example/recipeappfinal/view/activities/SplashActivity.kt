package com.example.recipeappfinal.view.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappfinal.db.FoodViewModel
import com.example.recipeappfinal.utils.FoodUtils
import com.example.recipeppfinal.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashBinding
    private lateinit var foodViewModel: FoodViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addDataToDb()
        setInitViews()
        setClickListeners()
    }

    private fun addDataToDb() {
//        val foodDao = FoodDatabase.getInstance(application).itemDao()
//        val repository = FoodRepository(foodDao)
        foodViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(FoodViewModel::class.java)
        foodViewModel.allFoods.observe(this){
            if(it.isEmpty())
            {
                foodViewModel.insertItems(FoodUtils.addAllList()).also {
                    Toast.makeText(this, "All Data Added "+foodViewModel.allFoods, Toast.LENGTH_SHORT).show()
                }
            }
        }



    }

    private fun setInitViews() {
        Handler().postDelayed({
            binding.progressSplash.visibility = View.GONE
            binding.btnContinue.visibility = View.VISIBLE
        },5000)
    }

    private fun setClickListeners() {
        binding.btnContinue.setOnClickListener()
        {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}