package com.akyuzg.dailyaffimration.data.database.model

import androidx.room.*
import com.akyuzg.dailyaffimration.domain.model.Affirmation

@Entity(tableName = "affirmations")
data class AffirmationAndData(
    @PrimaryKey
    val id: Long,
    val text: String,
    @ColumnInfo(name = "category_id") val categoryId: Int,

    @Relation(parentColumn = "id", entityColumn = "id")
    var like: Like? = null,

    @Relation(parentColumn = "id", entityColumn = "id")
    var bookmark: Bookmark? = null
)


fun AffirmationAndData.toDomainModal(): Affirmation {
    return Affirmation(
        id = id,
        text = text,
        categoryId = categoryId,
        liked = like != null,
        bookmarked = bookmark != null
    )
}
