package co.gul.ui.screen

import androidx.compose.runtime.Composable
import co.gul.model.screen.Screen
import co.gul.ui.component.SiteFooter
import co.gul.ui.component.TagChip
import co.gul.ui.theme.AppStyle
import co.gul.ui.theme.Font
import co.gul.ui.theme.Palette
import co.gul.ui.theme.Spacing
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

private val BLE_TAGS = listOf("Java", "Kotlin", "KMP", "BLE", "Wi-Fi P2P", "NSD", "MediaCodec", "OpenGL ES", "RTMP")
private val PROJECT_TAGS_LINGER = listOf("BLE", "Wi-Fi P2P", "NSD", "Proximity", "Discovery")
private val PROJECT_TAGS_VELLUM = listOf("Kotlin/JS", "GitHub Actions", "CI/CD")

@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
    Main {
        // ── Hero ──────────────────────────────────────────────────────────────
        Section(attrs = {
            classes(AppStyle.heroSection)
            attr("aria-label", "Introduction")
        }) {
            // Left: headline copy
            Div {
                H1(attrs = { classes(AppStyle.heroHeading) }) {
                    Text("Android Developer, ")
                    Br()
                    Em(attrs = { classes(AppStyle.heroAccent) }) { Text("proximity tech") }
                    Br()
                    Text("& low-level systems.")
                }

                P(attrs = { classes(AppStyle.heroBody) }) {
                    Text(
                        "Six years shipping Android apps at scale — from BLE and Wi-Fi P2P based automated attendance systems at 99%+ accuracy, to native RTMP pipelines, OpenGL ES renderers, and IoT use cases. Currently building Linger: a no-internet proximity-first local discovery app with interest-based matchmaking."
                    )
                }

                Div(attrs = { classes(AppStyle.heroTags) }) {
                    BLE_TAGS.forEach { TagChip(it) }
                }

                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        gap(Spacing.md)
                        marginTop(Spacing.xl)
                    }
                }) {
                    Button(attrs = {
                        classes(AppStyle.btnPrimary)
                        onClick { onNavigate(Screen.Resume) }
                    }) { Text("View Resume") }

                    Button(attrs = {
                        classes(AppStyle.btnOutline)
                        onClick { onNavigate(Screen.Notebook) }
                    }) { Text("Read Notebook") }
                }
            }

            // Right: project cards
            Aside(attrs = { classes(AppStyle.heroVisual) }) {
                ProjectCard(
                    name = "Linger",
                    subtitle = "Connect to nearby people",
                    description = "A local discovery and connections app — no internet required. Interest-based matchmaking using local NLP on bios advertised inside BLE packets. Advertise, discover, connect and chat purely through local connections.",
                    tags = PROJECT_TAGS_LINGER,
                    status = "Active · Private beta"
                )
                ProjectCard(
                    name = "Vellum",
                    subtitle = "Automated \"Fork-to-Deploy\" Personal website",
                    description = "A data-driven web engine built with Kotlin/JS and Compose HTML. Decouples content from code via JSON/YAML configuration, enabling non-technical users to deploy professional-grade, glassmorphic portfolios via automated CI/CD pipelines.",
                    tags = PROJECT_TAGS_VELLUM,
                    status = "Active · Release phase"
                )
            }
        }

        // ── Stats row ─────────────────────────────────────────────────────────
        Section(attrs = {
            classes(AppStyle.statRow)
            attr("aria-label", "Career highlights")
        }) {
            StatCard("6+", "Years Android")
            StatCard("3", "Companies")
            StatCard("5", "Apps solely managed")
        }

        // ── Brief expertise summary ───────────────────────────────────────────
        Section(attrs = {
            style {
                property("max-width", "900px")
                property("margin", "0 auto")
                padding(0.px, Spacing.xl, Spacing.xxxl)
            }
        }) {
            H2(attrs = {
                style {
                    fontFamily(Font.display)
                    fontSize(32.px)
                    fontWeight(400)
                    color(Palette.onSurface)
                    property("letter-spacing", "-0.02em")
                    marginBottom(Spacing.xl)
                }
            }) { Text("Areas of experience") }

            ExpertiseGrid()
        }

        SiteFooter(onNavigate)
    }
}

@Composable
private fun ProjectCard(
    name: String,
    subtitle: String,
    description: String,
    tags: List<String>,
    status: String
) {
    Article(attrs = { classes(AppStyle.projectCard) }) {
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.FlexStart)
            }
        }) {
            Div {
                H3(attrs = { classes(AppStyle.projectCardTitle) }) { Text(name) }
                P(attrs = {
                    style {
                        fontFamily(Font.mono)
                        fontSize(12.px)
                        color(Palette.primary)
                        marginTop(4.px)
                        property("letter-spacing", "0.03em")
                    }
                }) { Text(subtitle) }
            }
            Span(attrs = {
                style {
                    fontFamily(Font.mono)
                    fontSize(11.px)
                    color(Palette.onSurfaceVariant)
                    property("letter-spacing", "0.04em")
                    property("white-space", "nowrap")
                }
            }) { Text(status) }
        }

        P(attrs = { classes(AppStyle.projectCardBody) }) { Text(description) }

        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(6.px)
                marginTop(Spacing.md)
            }
        }) {
            tags.forEach { TagChip(it) }
        }
    }
}

@Composable
private fun StatCard(value: String, label: String) {
    Article(attrs = { classes(AppStyle.statCard) }) {
        P(attrs = { classes(AppStyle.statNumber) }) { Text(value) }
        P(attrs = { classes(AppStyle.statLabel) }) { Text(label) }
    }
}

@Composable
private fun ExpertiseGrid() {
    val areas = listOf(
        Triple(
            "Proximity Systems", "bluetooth_searching",
            "BLE advertising/scanning, GATT, RSSI proximity, Wi-Fi P2P group formation, NSD mDNS — the full stack of Android's peer-to-peer primitives."
        ),
        Triple(
            "Media Pipeline", "videocam",
            "Hardware video encoding via MediaCodec, live RTMP streaming, Camera2, ExoPlayer, real-time audio processing, and activity recognition."
        ),
        Triple(
            "3D Rendering", "view_in_ar",
            "OpenGL ES 2.0 on GLSurfaceView and TextureView, shaders, and 3D motion path visualisation for sports analytics."
        ),
        Triple(
            "Clean Architecture", "architecture",
            "MVVM, MVI, Repository pattern, Use Case layering, modular Gradle setups, and Kotlin Coroutines / Flow."
        )
    )

    Div(attrs = {
        style {
            display(DisplayStyle.Grid)
            property("grid-template-columns", "1fr 1fr")
            gap(Spacing.md)
        }
    }) {
        areas.forEach { (title, _, description) ->
            Article(attrs = {
                style {
                    backgroundColor(Palette.surfaceContainer)
                    borderRadius(16.px)
                    padding(Spacing.lg, Spacing.xl)
                    border(1.px, LineStyle.Solid, Palette.outlineVariant)
                }
            }) {
                H3(attrs = {
                    style {
                        fontFamily(Font.body)
                        fontSize(15.px)
                        fontWeight(600)
                        color(Palette.onSurface)
                        marginBottom(Spacing.sm)
                    }
                }) { Text(title) }
                P(attrs = {
                    style {
                        fontFamily(Font.body)
                        fontSize(14.px)
                        lineHeight(1.65.em)
                        color(Palette.onSurfaceVariant)
                    }
                }) { Text(description) }
            }
        }
    }
}
