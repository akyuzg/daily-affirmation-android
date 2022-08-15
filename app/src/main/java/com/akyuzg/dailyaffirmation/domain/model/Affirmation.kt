package com.akyuzg.dailyaffirmation.domain.model


data class Affirmation(
    val id: Long,
    val text: String,
    val categoryId: Int,

    var liked : Boolean = false,
    var bookmarked : Boolean = false,
)

