package com.akyuzg.dailyaffimration.domain.usecase.affirmation

import com.akyuzg.dailyaffimration.common.Resource
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.domain.repository.AffirmationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class UpdateBookmarkUseCase @Inject constructor(
    private val repository: AffirmationRepository,
) {

    operator fun invoke(affirmation: Affirmation): Flow<Resource<BaseResponse>> = flow {
        try{
            emit(Resource.Loading())
            delay(500)
            val response = if(affirmation.bookmarked)
                repository.bookmark(affirmation.id)
            else
                repository.unBookmark(affirmation.id)

            emit(Resource.Success(response))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unknown error." ))
        }

    }
}