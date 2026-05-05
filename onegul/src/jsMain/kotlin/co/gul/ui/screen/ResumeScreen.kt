package co.gul.ui.screen

import androidx.compose.runtime.Composable
import co.gul.model.content.ROLES
import co.gul.model.content.Role
import co.gul.model.content.SKILLS
import co.gul.ui.component.Divider
import co.gul.ui.component.SectionHeader
import co.gul.ui.component.SiteFooter
import co.gul.ui.component.TagChip
import co.gul.ui.theme.AppStyle
import co.gul.ui.theme.Font
import co.gul.ui.theme.Palette
import co.gul.ui.theme.Spacing
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

private val PROJECT_TAGS_LINGER = listOf("BLE", "Wi-Fi P2P", "NSD", "Proximity", "Discovery")
private val PROJECT_TAGS_VELLUM =
    listOf("Kotlin", "KMP", "Coroutines", "Kotlin/Native", "SRT", "NAL", "JNI", "cinterop")

@Composable
fun ResumeScreen() {
    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            Header {
                SectionHeader(
                    heading = "Resume",
                    subheading = "Six years of Android development across ed-tech, sports analytics, live-streaming, " +
                            "and fitness. Developed and launched automated attendance system and RTMP live-streaming " +
                            "apps from scratch."
                )
            }

            Divider()

            // Timeline
            Section(attrs = { attr("aria-label", "Work history") }) {
                H2(attrs = {
                    style {
                        fontFamily(Font.DISPLAY)
                        fontSize(28.px)
                        fontWeight(400)
                        color(Palette.onSurface)
                        property("letter-spacing", "-0.02em")
                        marginBottom(Spacing.sm)
                    }
                }) { Text("Work History") }

                Ol(attrs = { classes(AppStyle.timeline) }) {
                    ROLES.forEach { role -> RoleCard(role) }
                }
            }

            Divider()

            // Skills
            Section(attrs = { attr("aria-label", "Technical skills") }) {
                H2(attrs = {
                    style {
                        fontFamily(Font.DISPLAY)
                        fontSize(28.px)
                        fontWeight(400)
                        color(Palette.onSurface)
                        property("letter-spacing", "-0.02em")
                        marginBottom(Spacing.sm)
                    }
                }) { Text("Technical Skills") }

                Div(attrs = { classes(AppStyle.skillsGrid) }) {
                    SKILLS.forEach { skill ->
                        Article(attrs = { classes(AppStyle.skillCard) }) {
                            P(attrs = { classes(AppStyle.skillCategory) }) { Text(skill.category) }
                            Ul(attrs = { classes(AppStyle.skillItems) }) {
                                skill.items.forEach { item ->
                                    Li { TagChip(item) }
                                }
                            }
                        }
                    }
                }
            }

            Divider()

            // Education / misc
            Section(attrs = { attr("aria-label", "Education and background") }) {
                H2(attrs = {
                    style {
                        fontFamily(Font.DISPLAY)
                        fontSize(28.px)
                        fontWeight(400)
                        color(Palette.onSurface)
                        property("letter-spacing", "-0.02em")
                        marginBottom(Spacing.xl)
                    }
                }) { Text("Projects") }

                Div(attrs = {
                    style {
                        display(DisplayStyle.Grid)
                        gap(Spacing.md)
                    }
                }) {
                    ProjectCard(
                        name = "Linger",
                        subtitle = "Connect to nearby people",
                        description = "A local discovery and connections app — no internet required. Interest-based matchmaking using local NLP on bios advertised inside BLE packets. Shows 'Reads Proust', 'loves trekking' on nearby profile discoveries. Advertise, discover, connect and chat with nearby people purely through local connections.",
                        tags = PROJECT_TAGS_LINGER,
                        status = "Active · Private beta"
                    )
                    ProjectCard(
                        name = "Srtium",
                        subtitle = "An SRT live-streaming KMP library targeting Android and iOS",
                        description = "A lightweight library for adding low-latency SRT live-streaming to Kotlin Multiplatform mobile apps, with JNI and Kotlin/Native cinterop bindings to libsrt. Designed a coroutine-first API with lock-free ring buffers, zero-copy buffer pipelines, and backpressure-aware bidirectional Flows to keep allocations off the hot path. Structured as a multi-module Gradle project with explicit API mode, binary compatibility validation, and R8/ProGuard rules so unused modules tree-shake cleanly from final binaries.",
                        tags = PROJECT_TAGS_VELLUM,
                        status = "Active · Private beta"
                    )
                }
            }
        }

        SiteFooter()
    }
}

@Composable
private fun RoleCard(role: Role) {
    Li(attrs = { classes(AppStyle.timelineCard) }) {
        // Header row
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.FlexStart)
                flexWrap(FlexWrap.Wrap)
                gap(Spacing.sm)
            }
        }) {
            Div {
                H3(attrs = { classes(AppStyle.roleCompany) }) { Text(role.company) }
                P(attrs = { classes(AppStyle.roleTitle) }) { Text(role.title) }
            }
            Div(attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Column)
                    alignItems(AlignItems.FlexEnd)
                    gap(4.px)
                }
            }) {
                Span(attrs = { classes(AppStyle.rolePeriod) }) { Text(role.period) }
                Span(attrs = {
                    style {
                        fontFamily(Font.MONO)
                        fontSize(12.px)
                        color(Palette.onSurfaceVariant)
                        property("letter-spacing", "0.03em")
                    }
                }) { Text(role.location) }
            }
        }

        // Summary
        P(attrs = { classes(AppStyle.roleSummary) }) { Text(role.summary) }

        // Highlights
        Ul(attrs = { classes(AppStyle.roleHighlights) }) {
            role.highlights.forEach { h ->
                Li(attrs = { classes(AppStyle.highlight) }) {
                    // Bullet marker
                    Span(attrs = {
                        style {
                            position(Position.Absolute)
                            left(0.px)
                            color(Palette.primary)
                            fontFamily(Font.MONO)
                        }
                    }) { Text("·") }
                    Text(h)
                }
            }
        }

        // Tags
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                flexWrap(FlexWrap.Wrap)
                gap(6.px)
                marginTop(Spacing.md)
            }
        }) {
            role.tags.forEach { TagChip(it) }
        }
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
                        fontFamily(Font.MONO)
                        fontSize(12.px)
                        color(Palette.primary)
                        marginTop(4.px)
                        property("letter-spacing", "0.03em")
                    }
                }) { Text(subtitle) }
            }
            Span(attrs = {
                style {
                    fontFamily(Font.MONO)
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
