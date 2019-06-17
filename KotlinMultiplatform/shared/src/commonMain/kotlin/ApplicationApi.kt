package com.yasiralijaved.kotlinmultiplatform.shared

import com.yasiralijaved.kotlinmultiplatform.shared.models.User
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import kotlinx.serialization.list


internal expect val ApplicationDispatcher: CoroutineDispatcher

@UseExperimental(kotlinx.serialization.ImplicitReflectionSerializer::class)
class ApplicationApi {

    private val client = HttpClient {}

    fun users(callback: (List<User>) -> Unit) {
        GlobalScope.apply {
            launch(ApplicationDispatcher) {
                val result: String = client.get("https://jsonplaceholder.typicode.com/users")
                val userList = Json.parse(User.serializer().list, result)
                callback(userList)
            }
        }
    }
}