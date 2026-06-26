package com.example.lab6.data.repository

import com.example.lab6.data.model.Meal

interface MealRepository {
    suspend fun getMeal(): Result<List<Meal>>
}