object Dependencies {

    const val material = "com.google.android.material:material:${Versions.material}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val javaInject = "javax.inject:javax.inject:${Versions.javaInject}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    object Navigation {
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.ArchitectureComponents.navigation}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.ArchitectureComponents.navigation}"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object DaggerHilt {
        const val core = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    }




    object ArchitectureComponents{
        const val appCompat = "androidx.appcompat:appcompat:${Versions.ArchitectureComponents.appCompat}"
        const val coreKtx = "androidx.core:core-ktx:${Versions.ArchitectureComponents.core}"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.ArchitectureComponents.constraintLayout}"
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-beta01"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ArchitectureComponents.lifecycle}"
        const val viewModelRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.4.0-alpha03"

        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ArchitectureComponents.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.ArchitectureComponents.lifecycle}"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.ArchitectureComponents.lifecycleCommon}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.ArchitectureComponents.coroutines}"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.ArchitectureComponents.coroutines}"
        const val multidex = "androidx.multidex:multidex:${Versions.ArchitectureComponents.multidex}"
    }


    object GradlePlugins {
        const val androidGradle = "com.android.tools.build:gradle:${Versions.androidGradle}"
        const val navigation = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.ArchitectureComponents.navigation}"
        const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
    }

    object Test {
        const val junit = "junit:junit:${Versions.TestFrameworks.junit}"
        const val runner = "androidx.test:runner:${Versions.TestFrameworks.testRunner}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.TestFrameworks.espresso}"
        const val extJunit = "androidx.test.ext:junit:${Versions.TestFrameworks.testExtJunit}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.TestFrameworks.coroutines}"
    }


}