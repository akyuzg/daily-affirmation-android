package com.akyuzg.dailyaffirmation.di

import com.akyuzg.dailyaffirmation.common.Constants
import com.akyuzg.dailyaffirmation.data.database.AffirmationDao
import com.akyuzg.dailyaffirmation.data.network.AffirmationClient
import com.akyuzg.dailyaffirmation.data.network.AffirmationService
import com.akyuzg.dailyaffirmation.data.network.MainInterceptor
import com.akyuzg.dailyaffirmation.data.repository.AffirmationRepositoryImpl
import com.akyuzg.dailyaffirmation.domain.repository.AffirmationRepository
import com.akyuzg.dailyaffirmation.domain.usecase.affirmation.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(provideHttpLoggingInterceptor())
            .addInterceptor(MainInterceptor())
            .connectTimeout(45, TimeUnit.SECONDS)
            .readTimeout(45, TimeUnit.SECONDS)
            .writeTimeout(45, TimeUnit.SECONDS)
            .build()
    }

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level =
            if (com.akyuzg.dailyaffirmation.BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return httpLoggingInterceptor
    }

    @Provides
    @Singleton
    fun provideAffirmationApi(): AffirmationService {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(provideOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AffirmationService::class.java)
    }

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