package co.gul.ui.screen

import androidx.compose.runtime.Composable
import co.gul.model.content.ROLES
import co.gul.model.content.Role
import co.gul.model.content.SKILLS
import co.gul.model.screen.Screen
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

@Composable
fun ResumeScreen(onNavigate: (Screen) -> Unit) {
    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            Header {
                SectionHeader(
                    heading = "Resume",
                    subheading = "Six years of Android engineering across ed-tech, sports analytics, and fitness. " +
                            "Deep focus on native proximity systems, low-level media pipelines, and clean architecture."
                )
                Div(attrs = {
                    style {
                        display(DisplayStyle.Flex)
                        gap(Spacing.md)
                        marginTop(Spacing.xl)
                    }
                }) {
                    A(href = "/resume.pdf", attrs = {
                        classes(AppStyle.btnPrimary)
                        attr("download", "Gulshan_Resume.pdf")
                        attr("rel", "noopener")
                    }) { Text("Download PDF") }

                    A(href = "https://github.com/onegul", attrs = {
                        classes(AppStyle.btnOutline)
                        attr("target", "_blank")
                        attr("rel", "noopener noreferrer")
                    }) { Text("GitHub →") }
                }
            }

            Divider()

            // Timeline
            Section(attrs = { attr("aria-label", "Work history") }) {
                H2(attrs = {
                    style {
                        fontFamily(Font.display)
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
                        fontFamily(Font.display)
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
                        fontFamily(Font.display)
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
                        property("grid-template-columns", "1fr 1fr")
                        gap(Spacing.md)
                    }
                }) {
                    BackgroundCard(
                        "Linger",
                        "Ongoing",
                        "A BLE and Wi-Fi P2P based local discovery app with on-device NLP matchmaking."
                    )
                    BackgroundCard(
                        "Vellum",
                        "Feb 2026",
                        "Automated \"Fork-to-Deploy\" person website builder."
                    )
                }
            }
        }

        SiteFooter(onNavigate)
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
                        fontFamily(Font.mono)
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
                            fontFamily(Font.mono)
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
private fun BackgroundCard(title: String, period: String, description: String) {
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
            }
        }) { Text(title) }
        P(attrs = {
            style {
                fontFamily(Font.mono)
                fontSize(12.px)
                color(Palette.primary)
                marginTop(4.px)
                property("letter-spacing", "0.03em")
            }
        }) { Text(period) }
        P(attrs = {
            style {
                fontFamily(Font.body)
                fontSize(14.px)
                lineHeight(1.65.em)
                color(Palette.onSurfaceVariant)
                marginTop(Spacing.sm)
            }
        }) { Text(description) }
    }
}
