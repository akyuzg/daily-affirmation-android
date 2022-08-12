package com.akyuzg.dailyaffimration.presentation.affirmation_stack

import com.akyuzg.dailyaffimration.domain.model.Affirmation

sealed class AffirmationEvents {
    data class BookmarkChanged(val affirmation: Affirmation): AffirmationEvents()
    data class LikeChanged(val affirmation: Affirmation): AffirmationEvents()
}
