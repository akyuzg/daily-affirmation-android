import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate

fun Project.importArchitectureDependencies(){
    dependencies {
        val implementation by configurations

        implementation(Dependencies.Architecture.viewModel)
        implementation(Dependencies.Architecture.runtimeKtx)
        implementation(Dependencies.Architecture.lifecycleCommon)
        implementation(Dependencies.Architecture.livedata)
        implementation(Dependencies.Architecture.lifecycleCompiler)
        implementation(Dependencies.Architecture.constraintLayout)
        implementation(Dependencies.material3)
        implementation(Dependencies.material3WindowSizeClass)
        implementation(Dependencies.Accompanist.pager)
        //implementation(Dependencies.Accompanist.systemUiController)
    }
}

fun Project.importNetworkDependencies() {
    dependencies {
        val implementation by configurations

        implementation(Dependencies.Retrofit.core)
        implementation(Dependencies.Retrofit.gsonConverter)

        implementation(Dependencies.okHttp)
        implementation(Dependencies.okHttpLogging)
    }
}


fun Project.importCoroutinesDependencies() {
    dependencies {
        val implementation by configurations

        implementation(Dependencies.Architecture.coroutinesCore)
        implementation(Dependencies.Architecture.coroutinesAndroid)
    }
}


// apply common plugin
fun Project.importCommonDependencies() {
    dependencies {
        val implementation by configurations
        // to prevent listenable error
        implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")

        implementation(Dependencies.Architecture.splashScreen)
        implementation(Dependencies.Architecture.multidex)
    }
}

fun Project.importComposeDependencies(){
    dependencies {
        val implementation by configurations
        val debugImplementation by configurations

        implementation(Dependencies.Compose.ui)
        implementation(Dependencies.Compose.uiToolingPreview)
        debugImplementation(Dependencies.Compose.uiTooling)
        implementation(Dependencies.Compose.activityCompose)

        debugImplementation("androidx.customview:customview:1.2.0-alpha01")
        debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0-alpha01")

        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        implementation(Dependencies.Compose.foundation)

        // Material design icons
        implementation(Dependencies.Compose.materialIconsCore)
        implementation(Dependencies.Compose.materialIconsExtended)
        // Integration with observables
        //implementation(Dependencies.Compose.liveData)
        implementation(Dependencies.Compose.rxJava)

        implementation(Dependencies.Compose.animation)
        implementation(Dependencies.Compose.viewModel)
    }
}


