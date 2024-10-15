plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    kotlin("kapt")
}

android {
    namespace = "com.bye.ane.feature.market"
    compileSdk = libs.versions.compile.sdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.min.sdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.xRvDivider)
    implementation(libs.bundles.page.slice.ktx.combine)
    implementation(libs.utilcodex)
    implementation(libs.bundles.drouter.combine)
    //
    implementation(project(":core:global"))
    implementation(project(":core:environment"))
    implementation(project(":core:network"))
    implementation(project(":core:cheaps"))
    implementation(project(":core:resources"))
    implementation(project(":core:widget"))
    implementation(project(":shared:mvi"))
    //
    implementation(project(":feature:market-port"))
    //
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}