import com.android.build.api.dsl.ApplicationBuildType

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {

        fun addBuildConfigFields(applicationBuildType: ApplicationBuildType) {
            applicationBuildType.buildConfigField(
                "String",
                Configs.GEO_BASE_URL,
                properties.getValue("geo.base.url") as String
            )
            applicationBuildType.buildConfigField(
                "String",
                Configs.FORECAST_BASE_URL,
                properties.getValue("forecast.base.url") as String
            )
            applicationBuildType.buildConfigField(
                "String",
                Configs.FORECAST_APP_ID,
                properties.getValue("api.key") as String
            )
        }

        getByName("release") {
            addBuildConfigFields(this)
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }

        getByName("debug") {
            isDebuggable = true
            addBuildConfigFields(this)
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
    namespace = "com.chintan.forecastapp"
}

dependencies {

    // AndroidX
    implementation(AndroidX.coreKtx)
    implementation(AndroidX.appCompat)
    implementation(AndroidX.lifecycleKtx)
    implementation(AndroidX.activityCompose)

    implementation(AndroidX.navigationUi)
    implementation(AndroidX.navigationCompose)

    implementation(AndroidX.composeUi)
    implementation(AndroidX.composeMaterial)
    implementation(AndroidX.composeUiPreview)

    //Google
    implementation(Google.material)

    //Hilt
    implementation(Hilt.hiltAndroid)
    implementation(Hilt.hiltNavigationCompose)
    kapt(Hilt.hiltAndroidCompiler)

    //SquareUp
    implementation(SquareUp.retrofit)
    implementation(SquareUp.retrofitConverterGson)
    implementation(SquareUp.httpLoggingInterceptor)

    // Coroutine
    implementation(Coroutine.coroutinesAndroid)
    implementation(Coroutine.coroutinesCore)

    // Tests
    testImplementation(Test.junit)
    androidTestImplementation(Test.androidXJunit)
    androidTestImplementation(Test.espressoCore)
}

kapt {
    correctErrorTypes = true
}