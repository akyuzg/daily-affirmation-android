package com.akyuzg.dailyaffimration.presentation.affirmations

import com.akyuzg.dailyaffimration.domain.model.Affirmation

sealed class AffirmationEvent {
    data class BookmarkChanged(val affirmation: Affirmation): AffirmationEvent()
    data class LikeChanged(val affirmation: Affirmation): AffirmationEvent()
}
