package com.example.smart_development.feature_training_session.data.repository

import android.util.Log
import com.example.smart_development.feature_training_session.data.model.Message
import com.example.smart_development.feature_training_session.data.model.PromptModel
import com.example.smart_development.feature_training_session.data.network.TrainingService
import com.example.smart_development.feature_training_session.domain.model.TrainingSession
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import retrofit2.HttpException
import java.io.IOException

const val TAG = "RepositoryImpl"
const val ROLE = "user"
class RepositoryImpl(
    private val remote: TrainingService,
) : Repository {
    override fun getTraining(): Flow<List<TrainingSession>> {
//        return remote.getTraining()
        return emptyFlow()
    }

    override suspend fun createTraining(prompt: String): TrainingSession {
        val promptModel = PromptModel(
            messages = listOf(
                Message(content = prompt, role = ROLE)
            )
        )
//        Log.i(TAG, "createTraining: CreateTraining success")
        try{
            val response = remote.createTraining(promptModel)
            if(response.isSuccessful){
                Log.i(TAG, "createTraining: response success = ${response.body()}")
            }else{
                Log.i(TAG, "createTraining: response failure = ${response.body()}")
            }
        }catch(e: HttpException){
            Log.i(TAG, "createTraining: response HTTPException = ${e.message}")
        }catch(e: IOException){
            Log.i(TAG, "createTraining: response IOException = ${e.message}")
        }
        return TrainingSession(title = "Title", type = "Type")
    }
}

interface Repository {
    fun getTraining(): Flow<List<TrainingSession>>
    suspend fun createTraining(prompt: String): TrainingSession
}
