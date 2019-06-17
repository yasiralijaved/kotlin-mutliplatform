package com.yasiralijaved.kotlinmultiplatform.shared

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import io.ktor.client.*
import io.ktor.client.request.*



internal expect val ApplicationDispatcher: CoroutineDispatcher

class ApplicationApi {
    private val client = HttpClient {}

    fun users(callback: (String) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: String = client.get("https://jsonplaceholder.typicode.com/users")

                callback(result)
            }
        }
    }
}