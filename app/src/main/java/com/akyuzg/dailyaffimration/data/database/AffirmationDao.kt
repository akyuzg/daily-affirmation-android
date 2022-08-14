package com.akyuzg.dailyaffimration.data.database

import androidx.room.*
import com.akyuzg.dailyaffimration.data.database.model.Affirmation
import com.akyuzg.dailyaffimration.data.database.model.AffirmationAndData
import com.akyuzg.dailyaffimration.data.database.model.Bookmark
import com.akyuzg.dailyaffimration.data.database.model.Like

@Dao
interface AffirmationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(affirmation: Affirmation)


    @Transaction
    fun updateBookmarkData(bookmarks: List<Bookmark>) {
        deleteAllBookmarks()
        insertAllBookmarks(bookmarks)
    }

    @Insert
    fun insertAllBookmarks(bookmarks: List<Bookmark>)

    @Query("DELETE FROM bookmarks")
    fun deleteAllBookmarks()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertBookmark(bookmark: Bookmark)

    fun insertBookmark(affirmationId: Long) = insertBookmark(Bookmark(affirmationId))


    @Delete
    fun deleteBookmark(bookmark: Bookmark)

    fun deleteBookmark(affirmationId: Long)  = deleteBookmark(Bookmark(affirmationId))

    @Transaction
    fun updateLikeData(likes: List<Like>) {
        deleteAllLikes()
        insertAllLikes(likes)
    }

    @Insert
    fun insertAllLikes(likes: List<Like>)

    @Query("DELETE FROM likes")
    fun deleteAllLikes()


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertLike(like: Like)

    @Delete
    fun deleteLike(like: Like)

    fun deleteLike(affirmationId: Long) = deleteLike(Like(affirmationId))
    fun insertLike(affirmationId: Long) = insertLike(Like(affirmationId))



    @Query("SELECT EXISTS(SELECT * FROM bookmarks WHERE id = :affirmationId)")
    suspend fun isAffirmationExistInBookmarks(affirmationId: Long): Boolean

    @Query("SELECT EXISTS(SELECT * FROM likes WHERE id = :affirmationId)")
    suspend fun isAffirmationExistInLikes(affirmationId: Long): Boolean

    @Transaction
    @Query("SELECT * FROM affirmations")
    fun getAllAffirmationsAndData(): List<AffirmationAndData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAffirmations(order: List<Affirmation?>?)

}