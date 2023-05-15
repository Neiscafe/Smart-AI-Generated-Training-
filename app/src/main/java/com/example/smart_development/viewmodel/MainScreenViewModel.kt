package com.example.smart_development.viewmodel

import androidx.lifecycle.ViewModel
import com.example.smart_development.model.TrainingSession
import com.example.smart_development.repository.Repository
import kotlinx.coroutines.flow.Flow

class MainScreenViewModel(
    val repository: Repository
) : ViewModel() {
    suspend fun getTraining(prompt: String): Flow<TrainingSession> {
        return repository.getTraining(prompt)
    }
}