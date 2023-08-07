package com.example.recipeappfinal.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappfinal.view.activities.FoodDetailsActivity
import com.example.recipeappfinal.models.FoodModel
import com.example.recipeappfinal.view.adapters.RecipeAdapter
import com.example.recipeappfinal.db.FoodViewModel
import com.example.recipeppfinal.databinding.FragmentLunchBinding

class LunchFragment : Fragment() {
    lateinit var binding: FragmentLunchBinding
    lateinit var viewModel: FoodViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLunchBinding.inflate(inflater, container, false)
        val root: View = binding.getRoot()

        viewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        ).get(FoodViewModel::class.java)
        viewModel.getFoodItems("Lunch").observe(requireActivity())
        {
            val adapter = RecipeAdapter(requireContext(), it)
            binding.listViewRecipes.setAdapter(adapter)

            binding.listViewRecipes.setOnItemClickListener { parent, view, position, id ->
                // Handle item click here, for example, show a toast with the selected recipe's name
                val selectedRecipe: FoodModel = it.get(position)
                startActivity(
                    Intent(
                        requireContext(),
                        FoodDetailsActivity::class.java
                    ).putExtra("name", selectedRecipe.name)
                        .putExtra("difficulty", selectedRecipe.difficulty)
                        .putExtra("type", selectedRecipe.type)
                        .putExtra("ingredients", selectedRecipe.ingredients)
                        .putExtra("noOfPeople", selectedRecipe.noOfPeople.toString())
                )
            }
        }


        return root
    }
}