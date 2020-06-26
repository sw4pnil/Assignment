package com.test.assignment.requests

import com.test.assignment.util.Constants
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request

/**
 * @author swapnil-tml on 26-06-2020.
 * OkHttp Client used to handle json format
 */
object ServiceGenerator {
    private val request = Request.Builder()
            .url(Constants.BASE_URL)
    private val requestCall = request.build()
    private val client = OkHttpClient().newCall(requestCall)
    fun getCountryApiCall(): Call {
        return client
    }
}