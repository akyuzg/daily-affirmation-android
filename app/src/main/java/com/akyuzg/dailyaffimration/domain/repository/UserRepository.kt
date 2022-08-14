package com.akyuzg.dailyaffimration.domain.repository

import com.akyuzg.dailyaffimration.domain.model.User

interface UserRepository {

    suspend fun get(): User

    suspend fun put(user: User)
}