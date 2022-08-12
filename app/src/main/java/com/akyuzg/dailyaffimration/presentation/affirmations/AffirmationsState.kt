package com.akyuzg.dailyaffimration.presentation.affirmations

import com.akyuzg.dailyaffimration.domain.model.Affirmation

data class AffirmationsState(
    val isLoading: Boolean = false,
    val affirmations: List<Affirmation> = emptyList(),
    val message: String = "",
    val error: String = "",
    val visibleIndex: Int = 0
)