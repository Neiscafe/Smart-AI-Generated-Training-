package com.example.smart_development.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KEY = "sk-...Q0ly"
const val URL = "https://api.openai.com/v1/completions"
class RetrofitInit {
    companion object {
        fun create(context: Context?): TrainingService {
            val gson = GsonBuilder()
                .create()

            return Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(TrainingService::class.java)
        }
    }
}