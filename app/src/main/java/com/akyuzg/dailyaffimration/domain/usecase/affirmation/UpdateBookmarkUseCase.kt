package com.akyuzg.dailyaffimration.domain.usecase.affirmation

import com.akyuzg.dailyaffimration.common.Resource
import com.akyuzg.dailyaffimration.data.network.response.BaseResponse
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

    operator fun invoke(affirmationId: Long, bookmarked: Boolean): Flow<Resource<BaseResponse>> = flow {
        try{
            emit(Resource.Loading())
            delay(500)
            val response = repository.bookmark(affirmationId)
            if(response.ok){
                emit(Resource.Success(response))
            }else{
                response.message?.let { userMessage ->
                    emit(Resource.Message(userMessage))
                }
            }
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }

    }
}