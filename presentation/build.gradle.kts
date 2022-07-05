plugins {
    id(Plugins.androidLibrary)
    id(Plugins.jetbrainsKotlinAndroid)
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
        kotlinCompilerExtensionVersion =  "1.2.0"
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
    implementation(Dependencies.material)


    implementation(Dependencies.glide)

    annotationProcessor(Dependencies.glideCompiler)

    implementation(Dependencies.Navigation.fragmentKtx)
    implementation(Dependencies.Navigation.uiKtx)
    //implementation("androidx.navigation:navigation-compose:2.5.0")
    implementation(Dependencies.Navigation.compose)

    // Dependency Injection
    implementation(Dependencies.DaggerHilt.core)
    //kapt(Dependencies.DaggerHilt.core)

    // architecture  components
    implementation(Dependencies.Architecture.viewModel)
    implementation(Dependencies.Architecture.viewModelRuntime)
    implementation(Dependencies.Architecture.lifecycleCommon)
    implementation(Dependencies.Architecture.livedata)
    implementation(Dependencies.Architecture.lifecycleCompiler)
    implementation(Dependencies.Architecture.constraintLayout)


    implementation("androidx.compose.material3:material3:1.0.0-alpha01")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.ArchitectureComponents.compose}")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.ArchitectureComponents.compose}")
    debugImplementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
    debugImplementation("androidx.compose.ui:ui-test-manifest:${rootProject.extra["compose_version"]}")

}