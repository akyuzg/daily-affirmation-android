package com.akyuzg.dailyaffimration.data.network.response

import com.akyuzg.dailyaffimration.data.network.model.Affirmation
import com.google.gson.annotations.SerializedName

data class DailyAffirmationResponse(
    val ok: Boolean,
    val message: String?,
    @SerializedName(value = "daily_affirmations") val affirmations: List<Affirmation>
)
