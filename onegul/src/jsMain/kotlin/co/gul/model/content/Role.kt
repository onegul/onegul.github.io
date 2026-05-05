package co.gul.model.content

data class Role(
    val company: String,
    val title: String,
    val period: String,
    val location: String,
    val summary: String,
    val highlights: List<String>,
    val tags: List<String>
)

val ROLES = listOf(
    Role(
        company = "Acadly Inc.",
        title = "Android Development Engineer II - Android",
        period = "Aug 2022 – Sep 2025",
        location = "Gurugram, IN",
        summary = "Architected and shipped a proprietary automated attendance engine deployed at top universities across the USA, Europe, and IITs. Managed end-to-end releases of the Acadly Android apps, maintaining a 99.9% crash-free rate.",
        highlights = listOf(
            "Attendance Engine: Achieved 99%+ detection accuracy by orchestrating BLE, Wi-Fi P2P, NSD, WebSocket, Retrofit, Services, and UI across a heavily multithreaded module.",
            "App Ownership: Managed full Play Store release cycle — development, QA, release, and production bug tracking.",
            "Feature Development: Shipped complete app UI/UX redesign, custom Zoom SDK integration, real-time messaging, multi-language support, rich-text editors, and in-app payments.",
            "Architecture Migration: Led migration from legacy monolithic app codebase to MVVM + Clean Architecture, Modularization + Gradle Plugins and Build Variants, resolving long-standing code scalability and maintainability issues."
        ),
        tags = listOf(
            "Java",
            "Kotlin",
            "BLE",
            "Wi-Fi P2P",
            "NSD",
            "WebSocket",
            "Retrofit",
            "Hilt",
            "Zoom SDK",
            "MVVM",
            "Clean Architecture",
            "Build Variants",
            "Gradle Plugins",
            "Modularization"
        )
    ),

    Role(
        company = "StanceBeam",
        title = "Software Developer - Android",
        period = "May 2021 – May 2022",
        location = "Bangalore, IN",
        summary = "Managed the full lifecycle of both Android and iOS apps for StanceBeam IMU Striker. Built core video engineering features and a sensor-fusion iOS app for cricket bowling analytics.",
        highlights = listOf(
            "Video Engineering: Developed real-time batting/bowling detection, frame-by-frame video analysis, and pitch maps using MediaCodec, OpenGL ES, and MLKit.",
            "iOS Sensor App: Built an iOS app processing raw accelerometer, gyroscope, and magnetometer data to calculate arm speed, direction, and ball-type from StanceBeam IMU hardware.",
            "App Ownership: End-to-end responsibility for App Store and Play Store publishing, QA, and production stability monitoring."
        ),
        tags = listOf("Java", "Kotlin", "JNI", "MediaCodec", "OpenGL ES", "MLKit", "In-App Payments", "iOS", "Swift")
    ),

    Role(
        company = "ImStrong",
        title = "MediaCodec Engineer",
        period = "Sep 2020 – Feb 2021",
        location = "Bangalore, IN",
        summary = "Built a native live-streaming Android app from scratch — raw frame capture to RTMP transmission. Added real-time 3D pose detection and a full OpenGL ES graphics pipeline for live overlays.",
        highlights = listOf(
            "RTMP Pipeline: Used MediaCodec (H.264/AAC) to encode frames, wrote logic to packetize into FLV tags, and managed multithreaded synchronization between Camera, AudioRecord, and RTMP handshake states.",
            "Graphics Pipeline: Developed OpenGL ES (GLSL) shaders to render real-time overlays and activity recognition markers on live camera streams for trainers and trainees.",
            "Computer Vision: Integrated MLKit for real-time 3D pose detection on live video."
        ),
        tags = listOf("Java", "Kotlin", "Camera2", "MediaCodec", "H.264/AAC", "OpenGL ES", "GLSL", "RTMP", "MLKit")
    ),

    Role(
        company = "StanceBeam",
        title = "Software Developer – Android",
        period = "Nov 2019 – Sep 2020",
        location = "Bangalore, IN",
        summary = "Built core app features for the StanceBeam cricket analytics Android app and developed a BLE-based rope-skipping app that processed real-time IMU sensor data.",
        highlights = listOf(
            "Swing Detection: Implemented sensor-fusion with acoustic data (ball-to-bat impact sound) to improve event detection triggers.",
            "IoT & Sensor Fusion: Built a rope-skipping app interpreting raw BLE accelerometer, gyroscope and magnetometer data to count reps and calculate caloric burn.",
            "Feature Development: Built BLE connectivity, in-app payments, and custom video recording and editing surfaces.",
            "Offline-First: Implemented local data layer with push-based backend sync; collaborated with designers on full UI/UX refresh."
        ),
        tags = listOf("Java", "Kotlin", "BLE", "Sensor Fusion", "Offline-First", "MediaCodec", "OpenGL ES")
    )
)