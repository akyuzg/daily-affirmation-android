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
        kotlinCompilerExtensionVersion =  "1.3.0"
    }
}


importCommonDependencies()
importCoroutinesDependencies()
importNetworkDependencies()
importArchitectureDependencies()

dependencies {

    implementation(Dependencies.Compose.uiToolingPreview)
    debugImplementation(Dependencies.Compose.uiTooling)

    implementation(Dependencies.javaInject)
    implementation(Dependencies.Architecture.coreKtx)
    implementation(Dependencies.Architecture.appCompat)

    implementation(Dependencies.glide)
    annotationProcessor(Dependencies.glideCompiler)

    // Navigation
    implementation(Dependencies.Navigation.fragmentKtx)
    implementation(Dependencies.Navigation.uiKtx)
    implementation(Dependencies.Navigation.compose)

    // Dependency Injection
    implementation(Dependencies.DaggerHilt.core)
    kapt(Dependencies.DaggerHilt.compiler)
    implementation(Dependencies.DaggerHilt.navigation)

    // Room
    implementation(Dependencies.Room.runtime)
    implementation(Dependencies.Room.ktx)
    kapt(Dependencies.Room.compiler)

    implementation("io.coil-kt:coil-compose:2.2.0")

}