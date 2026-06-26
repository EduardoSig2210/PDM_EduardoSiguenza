package com.example.lab6.data.API.user

import com.example.lab6.data.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealResponse(
    val meals: List<MealDTO>? // The API returns null if no meals are found
)

@Serializable
data class MealDTO(
    val idMeal: String, // 👈 The API returns this as a String, not an Int
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)

fun MealDTO.toModel(): Meal {
    return Meal(
        idMeal = idMeal, // Make sure your Meal model's idMeal is also a String!
        strMeal = strMeal,
        strCategory = strCategory,
        strArea = strArea,
        strMealThumb = strMealThumb
    )
}