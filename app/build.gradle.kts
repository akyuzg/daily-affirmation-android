plugins {
    id(Plugins.androidApplication)
    id (Plugins.jetbrainsKotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinAndroid)
    id(Plugins.daggerHilt)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = Versions.App.id
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.App.versionCode
        versionName = Versions.App.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  "1.2.0"
    }
}


importCommonDependencies()
importTestDependencies()
importCoroutinesDependencies()
importNetworkDepencencies()

dependencies {

    // Dependency Injection
    implementation(Dependencies.DaggerHilt.core)
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.1.1")
    kapt(Dependencies.DaggerHilt.compiler)
    implementation(Dependencies.javaInject)

    // support
    implementation(Dependencies.Architecture.coreKtx)
    implementation(Dependencies.Architecture.appCompat)

    // ui
    implementation(Dependencies.Architecture.splashScreen)
    //implementation(Dependencies.material)

    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glideCompiler)

    implementation(Dependencies.Navigation.fragmentKtx)
    implementation(Dependencies.Navigation.uiKtx)
    //implementation("androidx.navigation:navigation-compose:2.5.0")
    implementation(Dependencies.Navigation.compose)

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:1.0.0")
    kapt("com.google.dagger:hilt-android-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")



    // architecture  components
    implementation(Dependencies.Architecture.viewModel)
    implementation(Dependencies.Architecture.runtimeKtx)
    implementation(Dependencies.Architecture.lifecycleCommon)
    implementation(Dependencies.Architecture.livedata)
    implementation(Dependencies.Architecture.lifecycleCompiler)
    implementation(Dependencies.Architecture.constraintLayout)

    implementation(Dependencies.material3)
    implementation(Dependencies.material3WindowSizeClass)

    // Local unit tests
    //testImplementation("androidx.test.core:1.4.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    testImplementation("junit:junit:3.13.2")
    testImplementation("androidx.arch.core:core-testing:2.1.0")
    testImplementation("com.google.truth:truth:1.1.3")
    //testImplementation("com.squareup.okhttp3.mockwebserver:4.9.1")
    //testImplementation("io.mockk:mockk:1.10.5")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.1.0-alpha04")

    // Instrumentation tests
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.0")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.37")
    kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.37")
    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.1.0")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    //androidTestImplementation("com.squareup.okhttp3.mockwebserver:4.9.1")
    //androidTestImplementation("io.mockk:mockk:1.10.5")
    androidTestImplementation("androidx.test:runner:1.4.0")

    implementation("androidx.multidex:multidex:2.0.1")

}