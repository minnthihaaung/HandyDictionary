plugins {
  id("com.android.application")
  id("kotlin-android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
}

android {
  namespace = "com.mta.handydictionary"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.mta.handydictionary"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility(JavaVersion.VERSION_18)
    targetCompatibility(JavaVersion.VERSION_18)
  }
  kotlinOptions {
    jvmTarget = "18"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.8.0")
  implementation(platform("androidx.compose:compose-bom:2023.10.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  // Compose dependency
  implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

  // Coroutines
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

  // Coroutine lifecycle scope
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

  // Dagger Hilt
  implementation("com.google.dagger:hilt-android:2.48.1")
  kapt("com.google.dagger:hilt-compiler:2.48.1")
  kapt("androidx.hilt:hilt-compiler:1.0.0")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

  // Retrofit
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
  implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

  // Room
  implementation("androidx.room:room-runtime:2.5.2")
  kapt("androidx.room:room-compiler:2.5.2")

  // Kotlin Extensions and Coroutines support for Room
  implementation("androidx.room:room-ktx:2.5.2")

}