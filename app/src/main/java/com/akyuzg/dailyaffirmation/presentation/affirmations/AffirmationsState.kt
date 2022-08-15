package com.akyuzg.dailyaffirmation.presentation.affirmations

import com.akyuzg.dailyaffirmation.domain.model.Affirmation

data class AffirmationsState(
    val isLoading: Boolean = false,
    val affirmations: List<Affirmation> = emptyList(),
    val message: String = "",
    val error: String = "",
    val visibleIndex: Int = 0,
)