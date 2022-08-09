package com.akyuzg.dailyaffimration.presentation.affirmation_stack

import com.akyuzg.dailyaffimration.domain.model.Affirmation

data class AffirmationStackState(
    val isLoading: Boolean = false,
    val affirmations: List<Affirmation> = emptyList(),
    val message: String = "",
    val error: String = ""
)