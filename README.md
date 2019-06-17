# kotlin-mutliplatform
A project that demonstrates the Kotlin Multiplatform capabilities to develop Android and iOS Apps with code sharing. This sample project covers the most-used boilerplate code including 

1- Call and Http API (https://jsonplaceholder.typicode.com/users)
2- Parse (Deserialize) Json response (Sample List of Users) from Http API Call
3- Access the parsed (deserialize) data (List of Users) into Android and iOS
4- Display the list of users in Android and iOS Projects natively on the UI.

Following is the list of libraries that are used to execute all the features mentioned above
1- Ktor for http calls
2- kotlinx.serialization for Json Deserialization
3- kotlinx-coroutines that is mandatory for Ktor
4- mikepenz/FastAdapter [Android] to easily display the list of Users on the UI
