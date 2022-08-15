package com.akyuzg.dailyaffirmation.domain.repository

import com.akyuzg.dailyaffirmation.data.database.model.Affirmation
import com.akyuzg.dailyaffirmation.data.database.model.AffirmationAndData
import com.akyuzg.dailyaffirmation.data.network.response.BaseResponse
import com.akyuzg.dailyaffirmation.data.network.response.DailyAffirmationResponse

interface AffirmationRepository {

    suspend fun insertAllAffirmations(affirmations: List<Affirmation>)

    suspend fun getAffirmationsAndData(): List<AffirmationAndData>

    suspend fun getDailyAffirmations(): DailyAffirmationResponse

    suspend fun bookmark(affirmationId: Long): BaseResponse

    suspend fun unBookmark(affirmationId: Long): BaseResponse

    suspend fun like(affirmationId: Long): BaseResponse

    suspend fun unLike(affirmationId: Long): BaseResponse

}