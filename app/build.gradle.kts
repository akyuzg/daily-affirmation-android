plugins {
    id(Plugins.androidApplication)
    id (Plugins.jetbrainsKotlinAndroid)
    id(Plugins.kotlinKapt)
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
}


importCommonDependencies()
importTestDependencies()

dependencies {

    // Dependency Injection
    implementation(Dependencies.DaggerHilt.core)
    kapt(Dependencies.DaggerHilt.compiler)

    // Project modules
    implementation(project(Modules.presentation))
    implementation(project(Modules.domain))
    implementation(project(Modules.data))


}