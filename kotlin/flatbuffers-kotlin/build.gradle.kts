plugins {
  kotlin("multiplatform")
  id("convention.publication")
}


val libName = "Flatbuffers"
group = "com.google.flatbuffers.kotlin"
version = "2.0.0-SNAPSHOT"

kotlin {
  explicitApi()
  jvm()
  js(IR) {
    browser {
      testTask {
        enabled = false
      }
    }
    binaries.executable()
  }
  macosX64()
  macosArm64()
  iosArm64()
  iosSimulatorArm64()

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib-common"))
      }
    }
    val jvmMain by getting {
    }

    val macosX64Main by getting
    val macosArm64Main by getting
    val iosArm64Main by getting
    val iosSimulatorArm64Main by getting

    val nativeMain by creating {
      // this sourceSet will hold common cold for all iOS targets
      dependsOn(commonMain)
      macosArm64Main.dependsOn(this)
      macosX64Main.dependsOn(this)
      iosArm64Main.dependsOn(this)
      iosSimulatorArm64Main.dependsOn(this)
    }

    all {
      languageSettings.optIn("kotlin.ExperimentalUnsignedTypes")
    }
  }
}

// Fixes JS issue: https://youtrack.jetbrains.com/issue/KT-49109
rootProject.plugins.withType<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin> {
  rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"

}

fun String.intProperty() = findProperty(this).toString().toInt()
