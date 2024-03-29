package com.akyuzg.dailyaffirmation.data.network.model

import com.google.gson.annotations.SerializedName

data class Affirmation(
    val id: Long,

    @SerializedName(value = "affirmation")
    val text: String,

    @SerializedName(value = "affirmation_category_id")
    val categoryId: Int
)

fun Affirmation.toEntity() = com.akyuzg.dailyaffirmation.data.database.model.Affirmation(
    id = id,
    text = text,
    categoryId = categoryId
)
