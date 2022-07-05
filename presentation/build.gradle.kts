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
        jvmTarget = Versions.jvmTarget
    }
}

dependencies {

    // support
    implementation(Dependencies.Architecture.coreKtx)
    implementation(Dependencies.Architecture.appCompat)

    // ui
    implementation(Dependencies.Architecture.splashScreen)
    implementation(Dependencies.material)
    implementation(Dependencies.Navigation.fragmentKtx)
    implementation(Dependencies.Navigation.uiKtx)
    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glideCompiler)


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

}