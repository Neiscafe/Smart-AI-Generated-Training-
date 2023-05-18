package com.example.smart_development.feature_training_session.data.network

import android.content.Context
import com.example.smart_development.feature_training_session.data.model.ErrorResponse
import com.example.smart_development.feature_training_session.data.model.TrainingResponse
import com.example.smart_development.feature_training_session.data.model.WrapperResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type

const val KEY = "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"
const val URL = "https://api.openai.com/"

class RetrofitInit {
    companion object {
        fun create(context: Context?): TrainingService {
            val gson = GsonBuilder().registerTypeAdapter(
                WrapperResponse::class.java,
                WrapperResponseDeserializer()
            ).create()

            val client = OkHttpClient.Builder().addInterceptor(Interceptor { chain ->
                val newRequest =
                    chain.request().newBuilder().addHeader("Authorization", "Bearer " + KEY).build()
                chain.proceed(newRequest)
            }).build()

            return Retrofit.Builder().client(client).baseUrl(URL).addConverterFactory(
                GsonConverterFactory.create(gson)
            ).addCallAdapterFactory(
                CoroutineCallAdapterFactory()
            ).build().create(TrainingService::class.java)
        }
    }
}

class WrapperResponseDeserializer : JsonDeserializer<WrapperResponse> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?,
    ): WrapperResponse {
        val jsonObject = json?.asJsonObject
        val success = jsonObject?.getAsJsonObject("success")?.let {
            Gson().fromJson(it, TrainingResponse::class.java)
        }
        val failure = jsonObject?.getAsJsonObject("failure")?.let {
            Gson().fromJson(it, ErrorResponse::class.java)
        }
        return WrapperResponse(success, failure)
    }
}