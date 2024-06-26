plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"

}

android {
    namespace = "com.example.fillcare"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.fillcare"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures {
        viewBinding= true
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation (libs.androidx.fragment.ktx)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.scalars)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp)
    implementation (libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation (libs.converter.gson)
    implementation(libs.okhttp.v4120)

    //Timber
    implementation(libs.timber)

    //Log
    implementation(libs.logging.interceptor)



}