package com.akyuzg.dailyaffirmation.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "likes")
data class Like(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val affirmationId: Long
)