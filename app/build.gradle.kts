plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
    alias(libs.plugins.hiltAndroid)
}

android {
    namespace = "com.dicoding.tourismapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dicoding.tourismapp"
        minSdk = 28
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    dynamicFeatures += setOf(":maps")
}

dependencies {
    implementation(project(":core"))
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)

    //RXJAVA
    api(libs.rxjava)
    api(libs.rxandroid)
    api(libs.adapter.rxjava3)
    api(libs.androidx.room.rxjava3)
    api(libs.androidx.lifecycle.reactivestreams.ktx)

//    //DAGGER HILT
    api(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
}
