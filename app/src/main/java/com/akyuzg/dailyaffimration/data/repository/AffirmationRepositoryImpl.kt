package com.akyuzg.dailyaffimration.data.repository

import com.akyuzg.dailyaffimration.common.*
import com.akyuzg.dailyaffimration.data.network.AffirmationClient
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse
import com.akyuzg.dailyaffimration.domain.repository.AffirmationRepository
import javax.inject.Inject


class AffirmationRepositoryImpl @Inject constructor(
    private val affirmationClient: AffirmationClient
): AffirmationRepository {


    override suspend fun getDailyAffirmations(): DailyAffirmationResponse {
        return affirmationClient.getDailyAffirmations()
    }

    override suspend fun bookmark(affirmationId: Long): BaseResponse {
        return affirmationClient.bookmark(affirmationId)
    }

    override suspend fun unbookmark(affirmationId: Long): BaseResponse {
        return affirmationClient.unbookmark(affirmationId)
    }

    override suspend fun like(affirmationId: Long): BaseResponse {
        return affirmationClient.like(affirmationId)
    }

    override suspend fun unlike(affirmationId: Long): BaseResponse {
        return affirmationClient.unlike(affirmationId)
    }

}