package com.start.network

import com.start.network.utils.NetWorkLogNone
import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * NetWork Utils for [OkHttpClient]
 */
object NetWorkUtils {

    private val client = OkHttpClient.Builder()
        .addInterceptor(CommonInterceptor())
        .callTimeout(2000L, TimeUnit.SECONDS)
        .build()


    fun get(url: String, params: MutableMap<String, String>) {
        val request: Request = Request.Builder()
            .url(url)
            .build()

        val call = client.newCall(request)

        val response = call.execute()
    }

    fun post(url: String, params: MutableMap<String, String>) {
        val requestBody = FormBody.Builder()


        val request: Request = Request.Builder()
            .url(url)
            .build()

        val call = client.newCall(request)

       call.enqueue(object : Callback{
           override fun onFailure(call: Call, e: IOException) {
           }

           override fun onResponse(call: Call, response: Response) {
           }

       })
    }
}

class CommonInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        NetWorkLogNone.debug("CommonInterceptor", request.toString())
        return chain.proceed(request)
    }

}