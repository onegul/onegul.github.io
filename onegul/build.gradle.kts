plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

// Updated on 12/04/2026 at 22:03 IST
version = "1.0.1"

kotlin {
    jvmToolchain(21)

    js(IR) {
        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
                cssSupport { enabled = true }
            }
            runTask {
                mainOutputFileName = "app.js"
            }
            webpackTask {
                mainOutputFileName = "app.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html)
        }
    }
}


