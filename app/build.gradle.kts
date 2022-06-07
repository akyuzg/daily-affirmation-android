plugins {
    id(Plugins.androidApplication)
    id (Plugins.jetbrainsKotlinAndroid)
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = Versions.App.id
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.App.versionCode
        versionName = Versions.App.versionName

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

dependencies {

    implementation(Dependencies.ArchitectureComponents.coreKtx)
    implementation(Dependencies.ArchitectureComponents.appCompat)

    implementation(Dependencies.material)
    implementation(Dependencies.ArchitectureComponents.constraintLayout)

    // Test dependencies
    testImplementation(Dependencies.Test.junit)
    androidTestImplementation(Dependencies.Test.extJunit)
    androidTestImplementation(Dependencies.Test.espressoCore)

    implementation(Dependencies.ArchitectureComponents.splashScreen)

}