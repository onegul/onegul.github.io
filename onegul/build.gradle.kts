plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

version = "1.0.0"

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


