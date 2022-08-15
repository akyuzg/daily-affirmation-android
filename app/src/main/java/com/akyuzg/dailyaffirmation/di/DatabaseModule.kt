package com.akyuzg.dailyaffirmation.di

import android.app.Application
import androidx.room.Room
import com.akyuzg.dailyaffirmation.data.database.AffirmationDao
import com.akyuzg.dailyaffirmation.data.database.AffirmationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): AffirmationDatabase {
        return Room.databaseBuilder(
            app,
            AffirmationDatabase::class.java,
            AffirmationDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideAffirmationDao(db: AffirmationDatabase): AffirmationDao {
        return db.affirmationDao
    }

}