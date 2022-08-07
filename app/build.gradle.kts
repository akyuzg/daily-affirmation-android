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

    // Dependency Injection
    implementation(Dependencies.DaggerHilt.core)
    //kapt(Dependencies.DaggerHilt.com.akyuzg.dailyaffimration.core)

    // architecture  components
    implementation(Dependencies.Architecture.viewModel)
    implementation(Dependencies.Architecture.runtimeKtx)
    implementation(Dependencies.Architecture.lifecycleCommon)
    implementation(Dependencies.Architecture.livedata)
    implementation(Dependencies.Architecture.lifecycleCompiler)
    implementation(Dependencies.Architecture.constraintLayout)

    implementation(Dependencies.material3)
    implementation(Dependencies.material3WindowSizeClass)

    testImplementation(Dependencies.Test.junit)



}