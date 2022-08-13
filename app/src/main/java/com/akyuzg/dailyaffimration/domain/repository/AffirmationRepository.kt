package com.akyuzg.dailyaffimration.domain.repository

import com.akyuzg.dailyaffimration.data.database.model.Affirmation
import com.akyuzg.dailyaffimration.data.database.model.AffirmationAndData
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse

interface AffirmationRepository {

    suspend fun insertAllAffirmations(affirmations: List<Affirmation>)

    suspend fun getAffirmationsAndData(): List<AffirmationAndData>

    suspend fun getLikes(): List<Long>

    suspend fun getBookmarks(): List<Long>

    suspend fun getDailyAffirmations(): DailyAffirmationResponse

    suspend fun bookmark(affirmationId: Long): BaseResponse

    suspend fun unBookmark(affirmationId: Long): BaseResponse

    suspend fun like(affirmationId: Long): BaseResponse

    suspend fun unLike(affirmationId: Long): BaseResponse

}