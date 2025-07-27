plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "lsh.xposed.jailmonkeybypass"
    compileSdk = 34

    defaultConfig {
        applicationId = "lsh.xposed.jailmonkeybypass"
        minSdk = 21
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
}

dependencies {

//    implementation(libs.appcompat)
//    implementation(libs.material)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.ext.junit)
//    androidTestImplementation(libs.espresso.core)

    compileOnly(libs.api)

//    compileOnly 'de.robv.android.xposed:api:82'
//    compileOnly 'de.robv.android.xposed:api:82:sources'
}
