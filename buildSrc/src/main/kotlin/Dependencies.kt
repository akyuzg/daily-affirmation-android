object Dependencies {

    const val material = "com.google.android.material:material:${Versions.material}"
    const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val material3WindowSizeClass = "androidx.compose.material3:material3-window-size-class:${Versions.material3}"


    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val javaInject = "javax.inject:javax.inject:${Versions.javaInject}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    object Navigation {
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.ArchitectureComponents.navigation}"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.ArchitectureComponents.navigation}"
        const val compose = "androidx.navigation:navigation-compose:2.5.0"
    }

    object Retrofit {
        const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object DaggerHilt {
        const val core = "com.google.dagger:hilt-android:${Versions.daggerHilt}"
        const val compiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    }

    object Compose {
        const val ui = "androidx.compose.ui:ui:${Versions.ArchitectureComponents.compose}"
        const val activityCompose = "androidx.activity:activity-compose:${Versions.ArchitectureComponents.activityCompose}"
        const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.ArchitectureComponents.compose}"
        const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.ArchitectureComponents.compose}"
        const val foundation = "androidx.compose.foundation:foundation:${Versions.ArchitectureComponents.compose}"
        const val material = "androidx.compose.material:material:${Versions.ArchitectureComponents.compose}"
        const val materialIconsCore = "androidx.compose.material:material-icons-com.akyuzg.dailyaffimration.core:${Versions.ArchitectureComponents.compose}"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.ArchitectureComponents.compose}"

        const val animation = "androidx.compose.animation:animation:${Versions.ArchitectureComponents.compose}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.ArchitectureComponents.composeViewModel}"

        const val liveData = "androidx.compose.runtime:runtime-livedata::${Versions.ArchitectureComponents.compose}"
        const val rxJava = "androidx.compose.runtime:runtime-rxjava2:${Versions.ArchitectureComponents.compose}"
    }

    object Architecture{
        const val appCompat = "androidx.appcompat:appcompat:${Versions.ArchitectureComponents.appCompat}"
        const val coreKtx = "androidx.com.akyuzg.dailyaffimration.core:com.akyuzg.dailyaffimration.core-ktx:${Versions.ArchitectureComponents.core}"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.ArchitectureComponents.constraintLayout}"
        const val splashScreen = "androidx.com.akyuzg.dailyaffimration.core:com.akyuzg.dailyaffimration.core-splashscreen:1.0.0-beta01"

        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ArchitectureComponents.lifecycle}"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.3.1"

        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ArchitectureComponents.lifecycle}"
        const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.ArchitectureComponents.lifecycle}"
        const val lifecycleCommon = "androidx.lifecycle:lifecycle-common-java8:${Versions.ArchitectureComponents.lifecycleCommon}"
        const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-com.akyuzg.dailyaffimration.core:${Versions.ArchitectureComponents.coroutines}"
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
        const val espressoCore = "androidx.test.espresso:espresso-com.akyuzg.dailyaffimration.core:${Versions.TestFrameworks.espresso}"
        const val extJunit = "androidx.test.ext:junit:${Versions.TestFrameworks.testExtJunit}"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.TestFrameworks.coroutines}"
        const val compose = "androidx.compose.ui:ui-test-junit4:${Versions.ArchitectureComponents.compose}"
    }

}