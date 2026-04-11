package co.gul.model.content

data class Skill(
    val category: String,
    val items: List<String>
)

val SKILLS = listOf(
    Skill("Languages & Core", listOf("Java", "Kotlin", "Jetpack Compose", "Coroutines", "KMP", "Swift (Beginner)")),
    Skill("Architecture and Flow", listOf("Hilt", "MVVM", "Clean Architecture", "Modularization")),
    Skill("Proximity & Wireless", listOf("BLE", "Wi-Fi P2P", "NSD", "WebSocket", "NFC", "Retrofit")),
    Skill("Media & Graphics", listOf("MediaCodec (H.264/AAC)", "Camera2", "OpenGL ES", "RTMP/FLV", "MLKit")),
    Skill("Build & Tooling", listOf("Gradle (Custom Plugins)", "Lint", "ProGuard/R8", "Protobuf"))
)