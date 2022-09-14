plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.squareup.sqldelight")
    id("com.google.devtools.ksp") version kspVersion
    id("publish-module")
}

project.apply {
    extra[KEY_PUBLISH_ARTIFACT_ID] = "auth"
    extra[KEY_PUBLISH_VERSION] = "1.0.0-alpha01"
    extra[KEY_SDK_NAME] = "Auth"
}

tasks.withType<Test> {
    useJUnitPlatform()
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = MIN_SDK
        targetSdk = TARGET_SDK

        buildConfigField(type = "String", name= "sdkVersion", value = "\"1.0.0-alpha01\"")
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = jvmVersion
        targetCompatibility = jvmVersion
    }

    kotlinOptions {
        jvmTarget = jvmVersion.toString()
    }
}

sqldelight {
    database("Database") {
        packageName = "com.walletconnect.auth"
        dependency(project(":androidCore:impl"))
    }
}

dependencies {
    implementation(project(":androidCore:impl"))
//    api(project(":androidCore:sdk"))

    timber()
    moshiKsp()
    androidXTest()
    robolectric()
    mockk()
    testJson()
    coroutinesTest()
    scarletTest()
    sqlDelightTest()
    jUnit5()
    jUnit5Android()
    web3jCrypto()
}