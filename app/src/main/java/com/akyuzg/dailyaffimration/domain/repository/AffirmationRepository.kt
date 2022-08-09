package com.akyuzg.dailyaffimration.domain.repository

import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse

interface AffirmationRepository {

    suspend fun getDailyAffirmations(): DailyAffirmationResponse

    suspend fun bookmark(affirmationId: Long): BaseResponse

    suspend fun like(affirmationId: Long): BaseResponse

}