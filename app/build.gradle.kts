@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.daggerHilt)
    kotlin("kapt")

}

android {
    namespace = "com.example.sonna"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.sonna"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode =ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = ConfigData.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = ConfigData.JAVA_VERSIONS_CODE
        targetCompatibility =ConfigData.JAVA_VERSIONS_CODE
    }
    kotlinOptions {
        jvmTarget = ConfigData.JAVA_VERSIONS_CODE.toString()
    }


    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(Modules.DATA_REPO))
    implementation(project(Modules.DATA_REMOTE))
    implementation(project(Modules.DATA_LOCAL))
    implementation(project(Modules.DOMAIN_USECASE))
    implementation(project(Modules.PRESENTATION_UI))


    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    implementation(libs.hiltCompose)
}