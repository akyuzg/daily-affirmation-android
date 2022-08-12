package com.akyuzg.dailyaffimration.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "likes")
data class Like(
    @PrimaryKey
    @ColumnInfo(name = "affirmation_id") val affirmationId: String
)