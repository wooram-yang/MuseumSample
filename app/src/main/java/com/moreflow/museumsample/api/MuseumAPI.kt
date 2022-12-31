package com.moreflow.museumsample.api

import com.moreflow.museumsample.BuildConfig
import com.moreflow.museumsample.entity.GalleryResponse
import com.moreflow.museumsample.entity.ImageResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MuseumAPI {
    @GET("gallery")
    suspend fun getGallery(
        @Query("apikey") apikey: String = BuildConfig.MUSEUM_API_KEY
    ): ApiResponse<GalleryResponse>

    @GET("image")
    suspend fun getImage(
        @Query("apikey") apikey: String = BuildConfig.MUSEUM_API_KEY,
        @Query("page") page: Int = 0
    ): ApiResponse<ImageResponse>
}