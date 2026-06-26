package com.example.lab6.data.repository

import com.example.lab6.data.API.KtorClient
import com.example.lab6.data.API.user.MealDTO
import com.example.lab6.data.API.user.toModel
import com.example.lab6.data.model.Meal
import io.ktor.client.call.body
import io.ktor.client.request.get

class MealRepositoryImp : MealRepository {
    override suspend fun getMeal(): Result<List<Meal>> {
        return try {
            val meals = KtorClient.client
                .get ("https://www.themealdb.com/api/json/v1/1/search.php?s=")
                .body<List<MealDTO>>()
                .map{ it.toModel()}
            Result.success(meals)
        } catch (e: Exception){
            Result.failure(e)
        }
    }

}