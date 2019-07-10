# kotlin-mutliplatform
A project that demonstrates the Kotlin Multiplatform capabilities to develop Android and iOS Apps with code sharing. 
With this approach, the software layers mentioned below have been moved out from native iOS and Android projects to a single shared project using kotlin language
1. Network Data Layer
1. Disk Data Layer
1. Data Access Layer
1. Repository Layer
1. Business Domain Layer

With this approach, the native platforms (Android and iOS) are only responsible to implement the Presentation Layer (UI) with their respective OS dependent lifecycles (e.g: Activity LifeCycle in Android).

#### This sample project covers the most-used boilerplate code including 

1. Call and Http API (https://jsonplaceholder.typicode.com/users)
1. Parse (Deserialize) Json response (Sample List of Users) from Http API Call
1. Access the parsed (deserialize) data (List of Users) into Android and iOS
1. Display the list of users in Android and iOS Projects natively on the UI.

#### Following is the list of libraries that are used to execute all the features mentioned above
1. Ktor for http calls
1. kotlinx.serialization for Json Deserialization
1. kotlinx-coroutines that is mandatory for Ktor
1. mikepenz/FastAdapter [Android] to easily display the list of Users on the UI

# Users List Screen
<image src="images/home-screen.png" />




#### Whats included in this sample project?
The common project fetches the list of users asynchronously (in a kotlin coroutine) from a restful api and then pass the result to the observer.

The observer in this sample are the consumers of the common(shared) project, i.e iOS and Android (UI) projects. These native projects are responsible to access the common class <b>ApplicationApi</b> and call its method <b>users()</b>. The iOS/Android projects observe the output of this method using Coroutine(Android) / Callback(iOS) and then display the results onto the UI.
