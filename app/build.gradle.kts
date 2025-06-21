plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.saad.cse.upay"
    compileSdk = 35


    defaultConfig {
        applicationId = "com.saad.cse.upay"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity)
    //CircleView
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    // ViewPager 2
    implementation ("androidx.viewpager2:viewpager2:1.0.0")
    // DotsIndicatorView
    implementation("com.tbuonomo:dotsindicator:5.1.0")
    // glide
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")
    // Bottom Nav labeled
    implementation ("com.google.android.material:material:1.9.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

}