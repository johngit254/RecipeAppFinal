package com.example.recipeappfinal.view.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipeappfinal.view.activities.FoodDetailsActivity
import com.example.recipeappfinal.models.FoodModel
import com.example.recipeappfinal.view.adapters.RecipeAdapter
import com.example.recipeappfinal.db.FoodViewModel
import com.example.recipeppfinal.databinding.FragmentBreakFastBinding


class BreakFastFragment : Fragment() {
    lateinit var binding: FragmentBreakFastBinding
    lateinit var viewModel: FoodViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentBreakFastBinding.inflate(inflater, container, false)
        val root: View = binding.getRoot()
        //Functions To Call
        viewModel =  ViewModelProvider(requireActivity(),ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)).get(FoodViewModel::class.java)
        viewModel.getFoodItems("Breakfast").observe(requireActivity())
        {
            val adapter = RecipeAdapter(requireContext(), it)
            binding.listViewRecipes.setAdapter(adapter)

            binding.listViewRecipes.setOnItemClickListener { parent, view, position, id ->
                // Handle item click here, for example, show a toast with the selected recipe's name
                val selectedRecipe: FoodModel = it.get(position)
                startActivity(Intent(requireContext(), FoodDetailsActivity::class.java).putExtra("name",selectedRecipe.name).putExtra("difficulty",selectedRecipe.difficulty).putExtra("type",selectedRecipe.type).putExtra("ingredients",selectedRecipe.ingredients).putExtra("noOfPeople",selectedRecipe.noOfPeople.toString()))
            }
        }



        return root
    }

}