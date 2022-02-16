# Lattice-Innovation-News-App
# Assignment
1. You need to create a news application by using an open API (https://newsapi.org/) to pull data from and create a UI similar to the picture shown below (next page). The functionalities that should be present in the app needs to be:

2. All the news should be present in a card view fashion
Each card should display each news post
One can search from the list and filter the card
Each card should have following details
Title
Description
Posted time ago e.g. 2 hours ago
Source of the news e.g. BBC
An image at the right side of the card

3. The cards should be sorted in a descending order with respect to the time. There should be 100 posts without any filter (show a count somewhere in the screen that represents the number of cards in the list when unfiltered or even when filtered)  and while scrolling there shouldn’t be any lag in UI so make sure to use the appropriate libraries.

# Tech - Stack :
Android Studio | Kotlin | Kotlin Extension & Plugin ->


plugins {

    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions'
    id 'kotlin-kapt'
    id 'dagger.hilt.android.plugin'

}

Dependencies -> 

dependencies {

    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.4.1'
    implementation 'com.google.android.material:material:1.5.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    //Retrofit
    def retrofit2_version = "2.9.0"
    def okhttp3_version = "4.9.0"
    implementation 'com.squareup.retrofit2:adapter-rxjava2:2.9.0'
    implementation "com.squareup.retrofit2:retrofit:$retrofit2_version"
    implementation "com.squareup.retrofit2:converter-gson:$retrofit2_version"
    implementation "com.squareup.okhttp3:okhttp:$okhttp3_version"

    // ViewModel and LiveData
    def arch_version = '2.2.0-alpha01'
    implementation "androidx.lifecycle:lifecycle-extensions:$arch_version"
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$arch_version"
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:$arch_version"

    // Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2'

    implementation 'de.hdodenhof:circleimageview:3.1.0'

    //pagination library
    def paging_version = "3.1.0-alpha03"
    implementation "androidx.paging:paging-runtime-ktx:$paging_version"
    // Retrofit dependency which will be used to make network calls
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    // GSON library which is used to convert POJO to JSON and vice versa
    implementation 'com.squareup.retrofit2:converter-gson:2.6.1'
    // okhttp library used to observe the api call logs on LogCat
    implementation 'com.squareup.okhttp3:logging-interceptor:4.9.0'

    implementation "com.google.dagger:hilt-android:2.38.1"
    kapt "com.google.dagger:hilt-compiler:2.38.1"

    implementation 'androidx.fragment:fragment-ktx:1.3.6'

    kapt 'com.github.bumptech.glide:compiler:4.12.0'

    //Image layout occurs in circular passion
    implementation 'de.hdodenhof:circleimageview:3.1.0'

}

# Specific reasons to use dependencies
# Dagger And Hilt
The dependency injection technique enables you to improve this even further. It provides a way to separate the creation of an object from its usage.
By doing that, we can replace a dependency without changing any code and it also reduces the boilerplate code in your business logic
    
# Glide 
We can reduce process of downloading and save in local file then we need to create bitmap
But if we use Glide library then we need not to write much code.

# Pagination library
The Paging Library helps you load and display small chunks of data at a time. Loading partial data on demand reduces usage of network bandwidth and system resources

# Retrofit dependency
Retrofit dependency which will be used to make network calls
GSON library which is used to convert POJO to JSON and vice versa
okhttp library used to observe the api call logs on LogCat

# Live data & View Model
Live data & View Model both are important parts of Android MVVM architecture

# Screenshot 📺 



# App Video











