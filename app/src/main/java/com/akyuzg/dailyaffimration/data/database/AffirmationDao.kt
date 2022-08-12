package com.akyuzg.dailyaffimration.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akyuzg.dailyaffimration.data.database.model.Affirmation
import com.akyuzg.dailyaffimration.data.database.model.AffirmationAndData
import com.akyuzg.dailyaffimration.data.database.model.Bookmark
import com.akyuzg.dailyaffimration.data.database.model.Like
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

@Dao
interface AffirmationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(affirmation: Affirmation)

    @Query("SELECT * FROM affirmations ORDER BY id DESC")
    fun getAll(): Flow<List<Affirmation>>

    @Query("SELECT * FROM affirmations")
    fun getAffirmationAndData(): Flow<List<AffirmationAndData>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLike(like: Like)

    @DELETE
    fun deleteLike(like: Like)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookmark(bookmark: Bookmark)

    @DELETE
    fun deleteBookmark(bookmark: Bookmark)

}