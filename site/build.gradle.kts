import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "musaib"
version = "0.21.1"

kobweb {
    app {
        index {

            description.set("Explore the portfolio of Musaib Shabir - A passionate Android developer specializing in Kotlin, Jetpack Compose, and modern mobile solutions.")
            head.add{
                link( rel="preconnect", href="https://fonts.googleapis.com")
                link( rel="preconnect",href="https://fonts.gstatic.com") {attributes["crossorigin"] = ""}
                link( href="https://fonts.googleapis.com/css2?family=Lexend:wght@100..900&display=swap", rel="stylesheet")
            }
        }
    }
}

kotlin {
    // This example is frontend only. However, for a fullstack app, you can uncomment the includeServer parameter
    // and the `jvmMain` source set below.
    configAsKobwebApplication("musaib" /*, includeServer = true*/)

    sourceSets {
        commonMain.dependencies {
          implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
        }
    }
}
