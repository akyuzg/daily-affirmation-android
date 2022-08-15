package com.akyuzg.dailyaffirmation.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "affirmations")
data class Affirmation(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo val id: Long,
    @ColumnInfo val text: String,
    @ColumnInfo(name = "category_id") val categoryId: Int?,


)