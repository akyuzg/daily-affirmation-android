package com.akyuzg.dailyaffirmation.presentation.affirmations

import com.akyuzg.dailyaffirmation.domain.model.Affirmation

sealed class AffirmationEvent {
    data class BookmarkChanged(val affirmation: Affirmation): AffirmationEvent()
    data class LikeChanged(val affirmation: Affirmation): AffirmationEvent()
}
