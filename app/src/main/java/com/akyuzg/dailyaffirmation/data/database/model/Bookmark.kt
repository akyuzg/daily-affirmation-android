package com.akyuzg.dailyaffirmation.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarks")
data class Bookmark(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val affirmationId: Long
)