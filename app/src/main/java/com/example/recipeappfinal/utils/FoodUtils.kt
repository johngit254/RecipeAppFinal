package com.example.recipeappfinal.utils

import com.example.recipeappfinal.models.FoodModel

object FoodUtils {
    fun getBreakfastRecipes(): ArrayList<FoodModel>
    {
        val breakfastFoodList: ArrayList<FoodModel> = ArrayList()
        breakfastFoodList.add(FoodModel(0,"Omelette","Breakfast","Beginner","Eggs, Milk, Cheese, Onions, Mushrooms, Salt, Black Pepper.",2))
        breakfastFoodList.add(FoodModel(0,"Pancakes","Breakfast","Intermediate","Flour, Milk, Eggs, Baking Powder, Salt, Butter.",5))
        breakfastFoodList.add(FoodModel(0,"Avocado Toast","Breakfast","Advanced","Bread, Avocado, Salt, Black Pepper, Lemon Juice, Red Pepper Flakes.",10))

        return breakfastFoodList
    }
    fun getLunchRecipes(): ArrayList<FoodModel>
    {
        val lunchFoodList: ArrayList<FoodModel> = ArrayList()

        lunchFoodList.add(FoodModel(0,"Rice+Beans","Lunch","Beginner","Rice, Beans, Tomatoes, Onions, Salt (optional).",2))
        lunchFoodList.add(FoodModel(0,"Chapo Beef","Lunch","Intermediate","Flour, Baking Powder, Oil, Butternut, Beef, Onions, Tomatoes",5))
        lunchFoodList.add(FoodModel(0,"Ugali Beef","Lunch","Advanced","Maize Flour, Cooking Oil, Beef, Tomato, Cucumber, Onion.",10))

        return lunchFoodList
    }
    fun getDinnerRecipes(): ArrayList<FoodModel>
    {
        var dinnerFoodList: ArrayList<FoodModel> = ArrayList()

        dinnerFoodList.add(FoodModel(0,"Ugali+Mayai","Dinner","Beginner"," Maize Flour, Eggs, Onion, Tomato, Cooking Oil,",2))
        dinnerFoodList.add(FoodModel(0,"Rice+Chicken","Dinner","Intermediate","Chicken, Lemon, Rice, Salt, Black Pepper, Coconut Oil.",5))
        dinnerFoodList.add(FoodModel(0,"Pilau+Beef","Dinner","Advanced","Rice, Pilau Masala, Beef, Garlic, Paprika,Soy Sauce.",10))

        return dinnerFoodList
    }
    fun getSnacksRecipes(): ArrayList<FoodModel>
    {
        var snacksFoodList: ArrayList<FoodModel> = ArrayList()

        snacksFoodList.add(FoodModel(0,"Chips","Snacks","Beginner","Potatoes, Cooking Oil, Salt,",2))
        snacksFoodList.add(FoodModel(0,"Samosa","Snacks","Intermediate","Flour, Minced Meat, Pepper,",5))
        snacksFoodList.add(FoodModel(0,"Burger","Snacks","Advanced"," Buns, Burger Meat, Cheese, Lettuce,Cherry Tomatoes, Ketchup.",10))

        return snacksFoodList
    }
    fun addAllList():ArrayList<FoodModel>
    {
        var allFoodList: ArrayList<FoodModel> = ArrayList()
        allFoodList.addAll(getBreakfastRecipes())
        allFoodList.addAll(getLunchRecipes())
        allFoodList.addAll(getDinnerRecipes())
        allFoodList.addAll(getSnacksRecipes())
        return allFoodList
    }
}