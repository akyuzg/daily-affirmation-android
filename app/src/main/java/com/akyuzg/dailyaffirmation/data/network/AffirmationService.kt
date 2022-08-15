package com.akyuzg.dailyaffirmation.data.network

import com.akyuzg.dailyaffirmation.data.network.response.BaseResponse
import com.akyuzg.dailyaffirmation.data.network.response.DailyAffirmationResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AffirmationService {

    @GET("/api/daily-affirmations")
    suspend fun getDailyAffirmations(): DailyAffirmationResponse

    @POST("/api/affirmations/{id}/bookmark")
    suspend fun bookmark(@Path("id") affirmationId: Long): BaseResponse

    @DELETE("/api/affirmations/{id}/unbookmark")
    suspend fun unBookmark(@Path("id") affirmationId: Long): BaseResponse


    @POST("/api/affirmations/{id}/like")
    suspend fun like(@Path("id") affirmationId: Long): BaseResponse


    @DELETE("/api/affirmations/{id}/unlike")
    suspend fun unLike(@Path("id") affirmationId: Long): BaseResponse

}