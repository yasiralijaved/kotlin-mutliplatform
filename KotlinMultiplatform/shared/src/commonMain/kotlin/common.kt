package com.yasiralijaved.kotlinmultiplatform.shared

expect fun platformName() : String

fun createApplicationScreenMessage() : String {
    return "Kotlin Rocks on ${platformName()}"
}

