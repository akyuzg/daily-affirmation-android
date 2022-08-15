package com.akyuzg.dailyaffirmation.di

import com.akyuzg.dailyaffirmation.data.database.AffirmationDao
import com.akyuzg.dailyaffirmation.data.network.AffirmationClient
import com.akyuzg.dailyaffirmation.data.network.AffirmationService
import com.akyuzg.dailyaffirmation.data.repository.AffirmationRepositoryImpl
import com.akyuzg.dailyaffirmation.domain.repository.AffirmationRepository
import com.akyuzg.dailyaffirmation.domain.usecase.affirmation.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAffirmationRepository(affirmationClient: AffirmationClient, affirmationDao: AffirmationDao): AffirmationRepository {
        return AffirmationRepositoryImpl(affirmationClient, affirmationDao)
    }

    @Provides
    @Singleton
    fun provideAffirmationClient(service: AffirmationService): AffirmationClient {
        return AffirmationClient(service)
    }

    @Provides
    @Singleton
    fun provideDailyAffirmationUseCase(affirmationRepository: AffirmationRepository): GetDailyAffirmationsUseCase {
        return GetDailyAffirmationsUseCase(affirmationRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateBookmarkUseCase(affirmationRepository: AffirmationRepository): UpdateBookmarkUseCase {
        return UpdateBookmarkUseCase(affirmationRepository)
    }

    @Provides
    @Singleton
    fun provideUpdateLikeUseCase(affirmationRepository: AffirmationRepository): UpdateLikeUseCase {
        return UpdateLikeUseCase(affirmationRepository)
    }

    @Provides
    @Singleton
    fun provideAffirmationUseCases(
        updateBookmarkUseCase: UpdateBookmarkUseCase,
        updateLikeUseCase: UpdateLikeUseCase,
        getDailyAffirmationsUseCase: GetDailyAffirmationsUseCase
    ): AffirmationUseCases {
        return AffirmationUseCases(
            updateBookmark = updateBookmarkUseCase,
            updateLike = updateLikeUseCase,
            getDailyAffirmations = getDailyAffirmationsUseCase
        )
    }


}