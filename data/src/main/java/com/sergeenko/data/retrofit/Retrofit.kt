package com.sergeenko.data.retrofit

import okhttp3.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException

internal const val baseUrl = "https://api.themoviedb.org/3/"
const val apiKey = "02b113b496621e5a49428c55c55a3ccc"

class RetrofitClient: IRetrofitClient {

    private val apiKeyInterceptor = Interceptor { chain ->
        val original = chain.request()
        val originalHttpUrl: HttpUrl = original.url()

        val url: HttpUrl = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        val requestBuilder: Request.Builder = original.newBuilder()
            .url(url)

        val request: Request = requestBuilder.build()

        try {
            chain.proceed(request)
        }catch (e: ConnectException){
            Response.Builder()
                .request(request)
                .protocol(Protocol.HTTP_1_0)
                .message("No Internet Connection")
                .body(ResponseBody.create(null, ""))
                .code(404)
                .build()
        }
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(apiKeyInterceptor)
        .build()

    private val  retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    override fun<T> create(java: Class<T>): T {
        return retrofit.create(java)
    }
}
