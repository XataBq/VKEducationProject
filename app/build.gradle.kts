plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.firstandroidapp"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.firstandroidapp"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    //room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    //retrofit
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.moshi)
    //okhttp
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    //moshi
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    ksp(libs.moshi.ksp)
    //timber
    implementation(libs.timber)
    // Hilt DI (Dependency Injection) + интеграция с Compose + KSP компилятор
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    //icons
    implementation(libs.androidx.compose.material.icons.extended)
    //coil
    implementation(libs.coil.compose)
    implementation(libs.coil.network.okhttp)
    //navigation
    implementation(libs.androidx.navigation.compose)
    // Core Android (KTX) + базовый runtime
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    // Jetpack Compose (UI toolkit) + BOM (единые версии Compose артефактов)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    // Unit tests (локальные JVM-тесты)
    testImplementation(libs.junit)
    // Instrumented / UI tests (тесты на устройстве/эмуляторе)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    // Debug-only (инструменты разработки, превью, манифест для UI тестов)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}