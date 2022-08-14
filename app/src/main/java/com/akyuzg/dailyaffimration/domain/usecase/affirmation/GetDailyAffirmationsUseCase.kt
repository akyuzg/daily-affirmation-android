package com.akyuzg.dailyaffimration.domain.usecase.affirmation

import com.akyuzg.dailyaffimration.common.Resource
import com.akyuzg.dailyaffimration.data.database.model.toDomainModal
import com.akyuzg.dailyaffimration.data.network.model.toEntity
import com.akyuzg.dailyaffimration.domain.model.Affirmation
import com.akyuzg.dailyaffimration.domain.repository.AffirmationRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDailyAffirmationsUseCase @Inject constructor(
    private val repository: AffirmationRepository,
) {

    operator fun invoke(): Flow<Resource<List<Affirmation>>> = flow {
        try{
            emit(Resource.Loading())

            val response = repository.getDailyAffirmations()
            val entities = response.affirmations.map { it.toEntity() }

            repository.insertAllAffirmations(entities)

            val items = repository.getAffirmationsAndData().map { it.toDomainModal() }


            emit(Resource.Success(items))
        }catch (e: Exception){
            emit(Resource.Error(e.message ?: "Unknown error." ))
        }
    }
}