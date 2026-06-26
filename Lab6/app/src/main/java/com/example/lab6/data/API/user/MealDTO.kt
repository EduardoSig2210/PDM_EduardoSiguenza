package com.example.lab6.data.API.user

import com.example.lab6.data.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class MealDTO(
    val idMeal: Int,
    val strMeal: String,
    val strCategory: String,
    val strArea: String,
    val strMealThumb: String
)
fun MealDTO.toModel(): Meal{
    return Meal(
        idMeal =  idMeal,
        strMeal =  strMeal,
        strCategory =  strCategory,
        strArea =  strArea,
        strMealThumb =  strMealThumb
    )
}