plugins {
    id(Plugins.androidLibrary)
    id(Plugins.jetbrainsKotlinAndroid)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
    }
    buildTypes {
        getByName("release") {
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}


importCoroutinesDependencies()
importNetworkDepencencies()

dependencies {

    implementation(Dependencies.javaInject)

    // Data Layer covers Domain Layer
    implementation(project(Modules.domain))
}