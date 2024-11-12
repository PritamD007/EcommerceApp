plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id ("androidx.navigation.safeargs")
    id ("kotlin-parcelize")


}

android {
    namespace = "com.example.ecommerceappfinal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ecommerceappfinal"
        minSdk = 28
        targetSdk = 35
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
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

    viewBinding{
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.firestore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)


    //Glide
    implementation (libs.glide)

    //circular image
    implementation (libs.circleimageview)


    //Android Ktx
    implementation (libs.androidx.navigation.fragment.ktx)

    implementation(libs.androidx.fragment.ktx)

// Core dependencies
    implementation (libs.androidx.core.ktx.v1150)
    implementation (libs.androidx.appcompat.v170)

    // Navigation Component
    implementation (libs.androidx.navigation.fragment.ktx.v273)
    implementation (libs.androidx.navigation.ui.ktx)

    // Material Components
    implementation (libs.material.v190)

    // (Optional) Kotlin extensions and other dependencies
    implementation (libs.kotlin.stdlib)

    //tablayout and viewpger
    implementation (libs.material.v1120)
    implementation (libs.androidx.viewpager2)


}

