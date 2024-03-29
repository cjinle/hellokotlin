package com.cjinle.utils

import okhttp3.*
import java.io.IOException

class TestHttp {
    private val url = "https://www.51voa.com/Technology_Report_1.html"
    fun run() {
        println("test http start ... ")
        sync()
    }

    fun sync() {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        val response = client.newCall(request).execute()
        println(response.body()?.string())
    }

    fun async() {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object: Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("fail...")
            }

            override fun onResponse(call: Call, response: Response) {
                println("succ...")
                println(response.body()?.string())
            }
        })
    }
}

