package com.akyuzg.dailyaffimration.data.network

import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse

class AffirmationClient(
    private val affirmationService: AffirmationService
) {

    suspend fun getDailyAffirmations(): DailyAffirmationResponse {
        return affirmationService.getDailyAffirmations()
    }

    suspend fun bookmark(affirmationId: Long): BaseResponse {
        return affirmationService.bookmark(affirmationId)
    }

    suspend fun like(affirmationId: Long): BaseResponse {
        return affirmationService.like(affirmationId)
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}