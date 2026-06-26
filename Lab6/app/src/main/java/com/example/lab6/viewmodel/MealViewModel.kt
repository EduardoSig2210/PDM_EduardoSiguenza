package com.example.lab6.viewmodel

import androidx.lifecycle.ViewModel
import com.example.lab6.data.model.Meal
import com.example.lab6.data.repository.MealRepository
import com.example.lab6.data.repository.MealRepositoryImp
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MealViewModel (
    private val repository: MealRepository = MealRepositoryImp()
): ViewModel(){
    private val _meal = MutableStateFlow<List<Meal>>(emptyList())
    val users: StateFlow<List<Meal>> = _meal.asStateFlow()
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    fun loadMeals(){
        viewModelScope.launch {
            _isLoading.value =true
            repository.getMeal()
                .onSuccess { _meal.value = it }
                .onFailure { it.printStackTrace() }
            _isLoading.value = false
        }
    }
}