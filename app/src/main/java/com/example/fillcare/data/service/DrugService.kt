package com.example.fillcare.data.service

import com.example.fillcare.R
import com.example.fillcare.data.model.DrugResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/"

private val okhttpclient =OkHttpClient.Builder()
    .connectTimeout(1,TimeUnit.MINUTES)
    .readTimeout(3,TimeUnit.SECONDS)
    .writeTimeout(3,TimeUnit.SECONDS)
    .build()

val gson : Gson = GsonBuilder()
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl(BASE_URL)
    .client(okhttpclient)
    .build()



interface DrugService {

    @GET("getDrbEasyDrugLista")
    suspend fun getDrugList(
        @Query("serviceKey") serviceKey : String,
        @Query("itemName") itemName : String,
        @Query("type") type : String,

        ):Result<DrugResponse>

}

object DrugApi {
    val retrofitService:  DrugService by lazy {
        retrofit.create(DrugService::class.java)
    }
}