package com.example.smart_development.feature_training_session.data.network

import android.content.Context
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val KEY = "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"
const val URL = "https://api.openai.com/v1/completions/"

class RetrofitInit {
    companion object {
        fun create(context: Context?): TrainingService {
            val gson = GsonBuilder().create()

            val client = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                val newRequest =
                    chain.request().newBuilder().addHeader("Authorization", "Bearer " + KEY).build()
                chain.proceed(newRequest)
            }).build()

            return Retrofit
                .Builder()
                .client(client)
                .baseUrl(URL)
                .addConverterFactory(
                    GsonConverterFactory.create(gson)
                )
                .addCallAdapterFactory(
                    CoroutineCallAdapterFactory()
                ).build()
                .create(TrainingService::class.java)
        }
    }
}