plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.bye.ane.faker"
    compileSdk = libs.versions.compile.sdk.get().toInt()
    defaultConfig {
        applicationId = libs.versions.application.id.get()
        minSdk = libs.versions.min.sdk.get().toInt()
        targetSdk = libs.versions.target.sdk.get().toInt()
        versionCode = libs.versions.version.code.get().toInt()
        versionName = libs.versions.version.name.get()
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    //
    signingConfigs {
        create("keyStore") {
            keyAlias = "fake"
            keyPassword = "fake"
            storeFile = file("../fake.jks")
            storePassword = "fake"
        }
    }
    //
    buildTypes {
        val signConfig = signingConfigs.getByName("keyStore")
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signConfig
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signConfig
        }
    }
    //
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.bundles.androidx.common.combine)

    implementation(libs.dgappstartup)
    //
    implementation(project(":core:environment"))
    implementation(project(":core:global"))
    implementation(project(":shared:store"))
    //
    implementation(project(":feature:index"))
    //
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}