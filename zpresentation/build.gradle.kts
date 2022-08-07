plugins {
    id(Plugins.androidLibrary)
    id(Plugins.jetbrainsKotlinAndroid)
    id(Plugins.kotlinAndroid)
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.composeCompiler
    }
    buildFeatures {
        compose = true
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


importComposeDependencies()

dependencies {

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