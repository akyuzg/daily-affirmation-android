package com.akyuzg.dailyaffimration.data.database.model

import androidx.room.*

@Entity(tableName = "affirmations")
data class AffirmationAndData(
    @PrimaryKey
    @ColumnInfo val id: Long,
    @ColumnInfo val text: String,
    @ColumnInfo(name = "category_id") val categoryId: Int,

    @Relation(
        parentColumn = "id",
        entityColumn = "affirmation_id"
    )
    @Embedded var like: Like? = null,


    @Relation(
        parentColumn = "id",
        entityColumn = "affirmation_id"
    )
    @Embedded var bookmark: Bookmark? = null
)