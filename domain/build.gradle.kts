plugins {
    id(Plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(Dependencies.Architecture.coroutinesCore)
    implementation(Dependencies.Architecture.coroutinesAndroid)
}