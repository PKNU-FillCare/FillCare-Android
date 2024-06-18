package com.example.fillcare.data.service

import com.example.fillcare.R
import com.example.fillcare.data.model.DrugResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.http.GET
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://apis.data.go.kr/1471000/DrbEasyDrugInfoService/"


val interceptor = HttpLoggingInterceptor()


private val okhttpClient =OkHttpClient.Builder()
    .addInterceptor(interceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
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
    .client(okhttpClient)
    .build()




interface DrugService {

    @GET("getDrbEasyDrugList")
    suspend fun getDrugList(
        @Query("serviceKey") serviceKey : String,
        @Query("itemName") itemName : String ,
        @Query("type") type : String,
        @Query("pageNo") pageNo : Int = 1,
        @Query("numOfRows") numOfRows : Int = 3

        ): DrugResponse

}

object DrugApi {
    val retrofitService:  DrugService by lazy {
        retrofit.create(DrugService::class.java)
    }
}