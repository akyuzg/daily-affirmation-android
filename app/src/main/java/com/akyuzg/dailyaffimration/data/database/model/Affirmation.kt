package com.akyuzg.dailyaffimration.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "affirmations")
data class Affirmation(
    @PrimaryKey
    @ColumnInfo val id: Long,
    @ColumnInfo val text: String,
    @ColumnInfo(name = "category_id") val categoryId: Int,

)