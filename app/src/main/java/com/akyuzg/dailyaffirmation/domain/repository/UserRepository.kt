package com.akyuzg.dailyaffirmation.domain.repository

import com.akyuzg.dailyaffirmation.domain.model.User

interface UserRepository {

    suspend fun get(): User

    suspend fun put(user: User)
}