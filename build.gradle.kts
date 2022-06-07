// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath(Dependencies.GradlePlugins.androidGradle)
        classpath(Dependencies.GradlePlugins.navigation)
        classpath(Dependencies.GradlePlugins.daggerHilt)
    }
}

plugins {
    id(Plugins.androidApplication) version Versions.applicationAndLibrary apply false
    id(Plugins.androidLibrary) version Versions.applicationAndLibrary apply false
    id(Plugins.jetbrainsKotlinAndroid) version Versions.kotlin apply false
    id(Plugins.jetbrainsKotlinJvm) version Versions.kotlin apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
