object DefaultConfig {
    const val appId = "com.rezyfr.dicoding.made"

    const val minSdk = 23
    const val targetSdk = 30
    const val compileSdk = 30
    const val buildTools = "30.0.3"

    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Modules {
    const val app = ":app"
    const val core = ":core"
    const val favorite = ":favmovie"
}

object Versions {
    const val kotlinVersion = "1.4.32"
    const val coreKtxVersion = "1.3.2"
    const val appCompatVersion = "1.2.0"
    const val materialVersion = "1.3.0"
    const val constraintLayoutVersion = "2.0.4"

    const val activityKtxVersion = "1.1.0"
    const val fragmentKtxVersion = "1.2.5"
    const val lifecycleVersion = "1.1.1"
    const val navVersion = "2.3.4"
    const val lifecycleKtxVersion = "2.3.1"

    const val hiltVersion = "1.0.0-alpha03"
    const val daggerHiltVersion = "2.32-alpha"

    const val coroutineVersion = "1.4.1"
    const val roomVersion = "2.2.6"

    const val pagingVersion = "3.0.0-alpha12"

    const val glideVersion = "4.10.0"
    const val glideLegacyVersion = "1.0.0"
    const val glideKaptVersion = "4.10.0"

    const val retrofitVersion = "2.7.1"
    const val okHttpInterceptorVersion = "4.5.0"
    const val okHttpVersion = "4.7.2"

    const val timberVersion = "4.7.1"

    const val lottieVersion = "3.6.0"
    const val shimmerVersion = "0.5.0"
    const val leakCanaryVersion = "2.6"

    const val mockkVersion = "1.10.0"
    const val junitVersion = "4.13"
    const val extJunitVersion = "1.1.2"
    const val espressoVersion = "3.3.0"
}

object Dependencies {
    // Base
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtxVersion}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}"
    const val lifeCycle = "android.arch.lifecycle:extensions:${Versions.lifecycleVersion}"
    const val lifecycleViewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleKtxVersion}"
    const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleKtxVersion}"

    // hilt
    const val hilt = "androidx.hilt:hilt-common:${Versions.hiltVersion}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltVersion}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltVersion}" //kapt
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.daggerHiltVersion}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-compiler:${Versions.daggerHiltVersion}"
    const val hiltTest =
        "com.google.dagger:hilt-android-testing:${Versions.daggerHiltVersion}" //androidTestImplementation

    // coroutine
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutineVersion}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutineVersion}"

    // Room
    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}" //kapt

    const val pagingRuntime = "androidx.paging:paging-runtime:${Versions.pagingVersion}"

    // Timber
    const val timber = "com.jakewharton.timber:timber:${Versions.timberVersion}"

    // Other
    const val navFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideLegacy = "androidx.legacy:legacy-support-v4:${Versions.glideLegacyVersion}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glideKaptVersion}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    // OkHttp
    const val interceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpInterceptorVersion}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttpVersion}"

    const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanaryVersion}"

    const val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}"

    // Test
    const val mockk = "io.mockk:mockk:${Versions.mockkVersion}"
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunitVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoVersion}"
}