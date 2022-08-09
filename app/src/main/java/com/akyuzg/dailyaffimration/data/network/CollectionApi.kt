package com.akyuzg.dailyaffimration.data.network

import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface CollectionApi {

    @GET("/collections")
    suspend fun getCollections(): Response<DailyAffirmationResponse>

    @POST("/collections")
    suspend fun createCollection(): Response<BaseResponse>

    @DELETE("/collections/{id}")
    suspend fun deleteCollection(@Path("id") collectionId: Int): Response<BaseResponse>

}