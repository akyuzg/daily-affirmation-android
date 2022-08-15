package com.akyuzg.dailyaffirmation.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.akyuzg.dailyaffirmation.data.database.model.Affirmation
import com.akyuzg.dailyaffirmation.data.database.model.Bookmark
import com.akyuzg.dailyaffirmation.data.database.model.Like

@Database(
    entities = [Affirmation::class, Bookmark::class, Like::class],
    version = 1,
    exportSchema = false
)
abstract class AffirmationDatabase: RoomDatabase() {

    abstract val affirmationDao: AffirmationDao

    companion object {
        const val DATABASE_NAME = "afirmation_db"
    }

}