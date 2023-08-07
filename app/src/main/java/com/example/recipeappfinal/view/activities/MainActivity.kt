package com.example.recipeappfinal.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.recipeappfinal.view.fragments.BreakFastFragment
import com.example.recipeappfinal.view.fragments.DinnerFragment
import com.example.recipeappfinal.view.fragments.LunchFragment
import com.example.recipeappfinal.view.fragments.SnacksFragment
import com.example.recipeppfinal.R
import com.example.recipeppfinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setClickListeners()

        loadFragment(BreakFastFragment())
    }

    private fun setClickListeners() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_breakfast -> {
                    loadFragment(BreakFastFragment())
                    true
                }
                R.id.navigation_lunch -> {
                    loadFragment(LunchFragment())
                    true
                }
                R.id.navigation_dinner -> {
                    loadFragment(DinnerFragment())
                    true
                }
                R.id.navigation_snacks -> {
                    loadFragment(SnacksFragment())
                    true
                }
                else -> {
                    loadFragment(SnacksFragment())
                    true
                }
            }
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.commit()
    }
    private fun showExitDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Exit")
        builder.setMessage("Are you sure you want to exit the app?")
        builder.setPositiveButton("Yes") { _, _ ->
            finishAffinity() // Finish the activity and exit the app
        }
        builder.setNegativeButton("No") { dialog, _ ->
            dialog.dismiss() // Dismiss the dialog if the user chooses not to exit
        }
        val dialog = builder.create()
        dialog.show()
    }

    override fun onBackPressed() {
        showExitDialog()
    }
}