object AndroidX {
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val lifecycleKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }

    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigation}" }
    val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Versions.navigation}" }

    val composeUi by lazy { "androidx.compose.ui:ui:${Versions.compose}"}
    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.compose}"}
    val composeUiPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"}
}

object Google {
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
}

object Hilt {
    val androidGradlePlugin by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }
    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hilt}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hilt}" }
    val hiltNavigationCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigationCompose}" }
}

object SquareUp {
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitConverterGson by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    val httpLoggingInterceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}" }
}

object Coroutine {
    val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }
}

object Test {
    val junit by lazy { "junit:junit:${Versions.junit}" }
    val androidXJunit by lazy { "androidx.test.ext:junit:${Versions.androidXJunit}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
}
