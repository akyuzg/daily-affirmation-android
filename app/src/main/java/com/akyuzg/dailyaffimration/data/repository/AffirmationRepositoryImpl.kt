package com.akyuzg.dailyaffimration.data.repository

import com.akyuzg.dailyaffimration.data.database.AffirmationDao
import com.akyuzg.dailyaffimration.data.database.model.Affirmation
import com.akyuzg.dailyaffimration.data.database.model.AffirmationAndData
import com.akyuzg.dailyaffimration.data.database.model.Bookmark
import com.akyuzg.dailyaffimration.data.database.model.Like
import com.akyuzg.dailyaffimration.data.network.AffirmationClient
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.DailyAffirmationResponse
import com.akyuzg.dailyaffimration.domain.repository.AffirmationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AffirmationRepositoryImpl @Inject constructor(
    private val affirmationClient: AffirmationClient,
    private val affirmationDao: AffirmationDao
): AffirmationRepository {

    override suspend fun insertAllAffirmations(affirmations: List<Affirmation>) = withContext(Dispatchers.IO) {
        affirmationDao.insertAllAffirmations(affirmations)
    }

    override suspend fun getAffirmationsAndData(): List<AffirmationAndData> = withContext(Dispatchers.IO) {
        return@withContext affirmationDao.getAllAffirmationsAndData()
    }

    override suspend fun getLikes(): List<Long> = withContext(Dispatchers.IO) {
        return@withContext affirmationDao.getLikes()
    }

    override suspend fun getBookmarks(): List<Long> = withContext(Dispatchers.IO) {
        return@withContext affirmationDao.getBookmarks()
    }

    override suspend fun getDailyAffirmations(): DailyAffirmationResponse {
        return affirmationClient.getDailyAffirmations()
    }

    override suspend fun bookmark(affirmationId: Long): BaseResponse = withContext(Dispatchers.IO) {
        val response = affirmationClient.bookmark(affirmationId)
        if(response.ok){
            affirmationDao.insertBookmark(affirmationId)
        }
        return@withContext response
    }

    override suspend fun unBookmark(affirmationId: Long): BaseResponse = withContext(Dispatchers.IO) {
        val response = affirmationClient.unBookmark(affirmationId)
        if(response.ok){
            affirmationDao.deleteBookmark(affirmationId)
        }
        return@withContext response
    }

    override suspend fun like(affirmationId: Long): BaseResponse = withContext(Dispatchers.IO) {
        val response = affirmationClient.like(affirmationId)
        if(response.ok){
            affirmationDao.insertLike(affirmationId)
        }
        return@withContext response
    }

    override suspend fun unLike(affirmationId: Long): BaseResponse = withContext(Dispatchers.IO) {
        val response = affirmationClient.unLike(affirmationId)
        if(response.ok){
            affirmationDao.deleteLike(affirmationId)
        }
        return@withContext response
    }

}