package com.akyuzg.dailyaffimration.data.network

import com.akyuzg.dailyaffimration.common.handleResponse
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse
import com.akyuzg.dailyaffimration.data.network.response.toBaseResponse

class AffirmationClient(
    private val affirmationService: AffirmationService
) {

    suspend fun getDailyAffirmations(): DailyAffirmationResponse {
        val response = affirmationService.getDailyAffirmations()
        handleResponse(response.toBaseResponse())
        return response
    }

    suspend fun bookmark(affirmationId: Long): BaseResponse {
        return handleResponse(affirmationService.bookmark(affirmationId))
    }

    suspend fun unBookmark(affirmationId: Long): BaseResponse {
        return handleResponse(affirmationService.unBookmark(affirmationId))
    }

    suspend fun like(affirmationId: Long): BaseResponse {
        return handleResponse(affirmationService.like(affirmationId))
    }

    suspend fun unLike(affirmationId: Long): BaseResponse {
        return handleResponse(affirmationService.unLike(affirmationId))
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}