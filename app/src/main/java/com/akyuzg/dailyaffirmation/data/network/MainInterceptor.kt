package com.akyuzg.dailyaffirmation.data.network

import com.akyuzg.dailyaffirmation.common.Constants.TOKEN
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class MainInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val originalHttpUrl: HttpUrl = original.url

        val url = originalHttpUrl.newBuilder()
            //.addQueryParameter("format", PhotoService.DEFAULT_FORMAT)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder()
            .addHeader("Authorization", "Bearer $TOKEN")
            .url(url)

        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}