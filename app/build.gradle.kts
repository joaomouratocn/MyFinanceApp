plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services")
}

android {
    namespace = "br.com.devjmcn.myfinanceapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "br.com.devjmcn.myfinanceapp"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    //ACCOMPANIST
    implementation(libs.google.accompanist.systemuicontroller)

    //VIEW-MODEL
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    //NAVIGATION
    implementation(libs.androidx.navigation.compose)

    //FIREBASE-INIT
    implementation(platform(libs.firebase.bom))

    //FIREBASE-COROUTINES
    implementation(libs.kotlinx.coroutines.play.services)

    //FIREBASE-ANALYTICS
    implementation(libs.firebase.analytics)

    //FIREBASE-AUTH
    implementation(libs.firebase.auth)

    //JBCRYPT
    implementation(libs.mindrot.jbcrypt)

    //GOOGLE ICONS
    implementation(libs.androidx.material.icons.extended)

    //KOIN
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}