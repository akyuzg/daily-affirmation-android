package com.akyuzg.dailyaffimration.domain.repository

import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.data.network.response.GetAllCollectionResponse
import com.akyuzg.dailyaffimration.domain.model.Collection

interface CollectionRepository {

    suspend fun getAll(page: Int): GetAllCollectionResponse

    suspend fun create(collection: Collection): BaseResponse

    suspend fun delete(collection: Collection): BaseResponse

}