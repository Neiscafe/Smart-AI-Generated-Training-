package com.example.smart_development.feature_training_session.data.network

import android.content.Context
import android.provider.Settings.System.getString
import com.example.smart_development.R
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val URL = "https://api.openai.com/"
const val KEY = "THE_APIKEY_IS_HIDDEN_REQUEST_ACCESS"

class RetrofitInit {
    companion object {
        fun create(context: Context?): TrainingService {
            val gson = GsonBuilder()
                /*.registerTypeAdapter(
                WrapperResponse::class.java,
                WrapperResponseDeserializer()
            )*/
                .create()

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
/*

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
}*/
