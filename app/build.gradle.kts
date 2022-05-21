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
        getByName("release") {
         //   buildConfigField("String", Configs.BASE_URL, properties.getValue("dev.base.url") as String)
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }

        getByName("debug") {
        //    buildConfigField("String", Configs.BASE_URL, properties.getValue("dev.base.url") as String)
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
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
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