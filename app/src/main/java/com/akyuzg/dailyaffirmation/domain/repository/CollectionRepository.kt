package com.akyuzg.dailyaffirmation.domain.repository

import com.akyuzg.dailyaffirmation.data.network.response.BaseResponse
import com.akyuzg.dailyaffirmation.data.network.response.GetAllCollectionResponse
import com.akyuzg.dailyaffirmation.domain.model.Collection

interface CollectionRepository {

    suspend fun getAll(page: Int): GetAllCollectionResponse

    suspend fun create(collection: Collection): BaseResponse

    suspend fun delete(collection: Collection): BaseResponse

}