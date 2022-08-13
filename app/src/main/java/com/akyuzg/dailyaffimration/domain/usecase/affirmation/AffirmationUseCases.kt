package com.akyuzg.dailyaffimration.domain.usecase.affirmation

import javax.inject.Inject

data class AffirmationUseCases @Inject constructor(
    val updateLike: UpdateLikeUseCase,
    val updateBookmark: UpdateBookmarkUseCase,
    val getDailyAffirmations: GetDailyAffirmationsUseCase
)