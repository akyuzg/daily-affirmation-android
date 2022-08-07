package com.akyuzg.dailyaffimration.domain.model

data class Affirmation(
    val id: Long,
    val affirmation: String,
    val categoryId: Int
)