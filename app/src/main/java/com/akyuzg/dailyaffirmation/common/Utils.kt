package com.akyuzg.dailyaffirmation.common

import com.akyuzg.dailyaffirmation.data.network.response.BaseResponse

@Throws(ServerException::class)
fun handleResponse(response: BaseResponse): BaseResponse {
    if(!response.ok){
        throw ServerException(response.message ?: "Unknown error.")
    }
    return response
}