package com.akyuzg.dailyaffirmation.domain.usecase.affirmation

import com.akyuzg.dailyaffirmation.common.Resource
import com.akyuzg.dailyaffirmation.data.network.response.BaseResponse
import com.akyuzg.dailyaffirmation.domain.model.Affirmation
import com.akyuzg.dailyaffirmation.domain.repository.AffirmationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateLikeUseCase @Inject constructor(
    private val repository: AffirmationRepository,
) {

    operator fun invoke(affirmation: Affirmation): Flow<Resource<BaseResponse>> = flow {
        try{
            emit(Resource.Loading())
            delay(500)
            val response = if (affirmation.liked)
                    repository.like(affirmation.id)
                else
                    repository.unLike(affirmation.id)

            emit(Resource.Success(response))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unknown error." ))
        }

    }
}