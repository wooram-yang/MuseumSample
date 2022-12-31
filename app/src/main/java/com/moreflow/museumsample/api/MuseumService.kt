package com.moreflow.museumsample.api

import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MuseumService {
    private const val BASE_URL = "https://api.harvardartmuseums.org"

    var api: MuseumAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MuseumAPI::class.java)
    }
}