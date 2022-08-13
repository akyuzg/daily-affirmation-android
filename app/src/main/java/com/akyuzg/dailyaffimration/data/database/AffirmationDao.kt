package com.akyuzg.dailyaffimration.data.database

import androidx.room.*
import com.akyuzg.dailyaffimration.data.database.model.Affirmation
import com.akyuzg.dailyaffimration.data.database.model.AffirmationAndData


@Dao
interface AffirmationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(affirmation: Affirmation)

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Query("INSERT INTO bookmarks VALUES(:affirmationId)")
    fun insertBookmark(affirmationId: Long)

    @Query("DELETE FROM bookmarks WHERE id = :affirmationId")
    suspend fun deleteBookmark(affirmationId: Long)

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    @Query("INSERT INTO likes VALUES(:affirmationId)")
    fun insertLike(affirmationId: Long)

    @Query("DELETE FROM likes WHERE id = :affirmationId")
    suspend fun deleteLike(affirmationId: Long)

    @Query("SELECT EXISTS(SELECT * FROM bookmarks WHERE id = :affirmationId)")
    suspend fun isAffirmationExistInBookmarks(affirmationId: Long): Boolean

    @Query("SELECT EXISTS(SELECT * FROM likes WHERE id = :affirmationId)")
    suspend fun isAffirmationExistInLikes(affirmationId: Long): Boolean

    @Transaction
    @Query("SELECT id FROM likes")
    fun getLikes(): List<Long>

    @Transaction
    @Query("SELECT id FROM bookmarks")
    fun getBookmarks(): List<Long>

    @Transaction
    @Query("SELECT * FROM affirmations")
    fun getAllAffirmationsAndData(): List<AffirmationAndData>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAffirmations(order: List<Affirmation?>?)

    /*

    @Transaction
    @Query("SELECT * FROM affirmations")
    fun getAllAffirmationAndData(): Flow<List<AffirmationAndData>>


      @Transaction
      @Query("SELECT * FROM affirmations ORDER BY id DESC")
      fun getAll(): Flow<List<Affirmation>>

      @Transaction
      @Query("SELECT * FROM affirmations")
      fun getAffirmationAndData(): Flow<List<AffirmationAndData>>




       */

}