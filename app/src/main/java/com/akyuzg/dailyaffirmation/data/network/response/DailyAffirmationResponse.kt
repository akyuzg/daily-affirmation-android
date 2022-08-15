package com.akyuzg.dailyaffirmation.data.network.response

import com.akyuzg.dailyaffirmation.data.network.model.Affirmation
import com.google.gson.annotations.SerializedName

data class DailyAffirmationResponse(
    val ok: Boolean,
    val message: String?,
    @SerializedName(value = "daily_affirmations") val affirmations: List<Affirmation>
)

fun DailyAffirmationResponse.toBaseResponse(): BaseResponse {
    return BaseResponse(
        ok = ok,
        message = message
    )
}
