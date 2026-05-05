package co.gul.model.content

data class Skill(
    val category: String,
    val items: List<String>
)

val SKILLS = listOf(
    Skill("Languages & Core", listOf("Java", "Kotlin", "Jetpack Compose", "Coroutines", "KMP", "NDK/JNI", "Swift (Beginner)")),
    Skill("Architecture & Scaling", listOf("Hilt", "MVVM", "Clean Architecture", "Modularization", "Build Variants")),
    Skill("Wireless (Nearby & Remote)", listOf("BLE", "Wi-Fi P2P", "NSD", "WebSocket", "NFC", "Retrofit")),
    Skill("Media & Graphics", listOf("MediaCodec (H.264/AAC)", "Camera2", "OpenGL ES", "RTMP/FLV", "MLKit")),
    Skill("Build & Tooling", listOf("Gradle (Custom Plugins)", "Lint", "ProGuard/R8", "Protobuf"))
)