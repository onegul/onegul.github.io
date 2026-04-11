package co.gul.ui.screen

import androidx.compose.runtime.*
import co.gul.model.content.NOTES
import co.gul.model.content.Note
import co.gul.model.content.NoteTag
import co.gul.model.screen.Screen
import co.gul.ui.component.Divider
import co.gul.ui.component.SectionHeader
import co.gul.ui.component.SiteFooter
import co.gul.ui.theme.AppStyle
import co.gul.ui.theme.Font
import co.gul.ui.theme.Palette
import co.gul.ui.theme.Spacing
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun NotebookScreen(onNavigate: (Screen) -> Unit) {
    var expanded by remember { mutableStateOf<Int?>(null) }

    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            Header {
                SectionHeader(
                    heading = "Notebook",
                    subheading = "Notes, observations, and drafts. Technical findings from BLE and Wi-Fi P2P work, " +
                            "ideas about proximity and decentralised systems, and the occasional philosophical aside."
                )
            }

            Divider()

            Section(
                attrs = {
                    classes(AppStyle.noteList)
                    attr("aria-label", "Notebook entries")
                }
            ) {
                NOTES.forEachIndexed { index, note ->
                    NoteCard(
                        note = note,
                        isExpanded = expanded == index,
                        onToggle = { expanded = if (expanded == index) null else index }
                    )
                }
            }

            Divider()

            // Colophon
            Aside(attrs = {
                style {
                    backgroundColor(Palette.surfaceContainer)
                    borderRadius(16.px)
                    padding(Spacing.xl)
                    border(1.px, LineStyle.Solid, Palette.outlineVariant)
                }
            }) {
                H3(attrs = {
                    style {
                        fontFamily(Font.display)
                        fontSize(22.px)
                        fontWeight(500)
                        color(Palette.onSurface)
                        property("letter-spacing", "-0.01em")
                        marginBottom(Spacing.sm)
                    }
                }) { Text("About this notebook") }
                P(attrs = {
                    style {
                        fontFamily(Font.body)
                        fontSize(14.px)
                        lineHeight(1.75.em)
                        color(Palette.onSurfaceVariant)
                    }
                }) {
                    Text(
                        "These are working notes, not polished essays. They document what I've found, what I'm thinking about, " +
                                "and what I haven't figured out yet. Technical notes lean toward Android proximity systems (BLE, Wi-Fi P2P, NSD). " +
                                "Observations and ideas wander further. I update this irregularly."
                    )
                }
            }
        }

        SiteFooter(onNavigate)
    }
}

@Composable
private fun NoteCard(note: Note, isExpanded: Boolean, onToggle: () -> Unit) {
    Article(attrs = {
        classes(AppStyle.noteCard)
        onClick { onToggle() }
        attr("role", "button")
        attr("aria-expanded", if (isExpanded) "true" else "false")
        style {
            if (isExpanded) {
                property("box-shadow", "0 4px 16px rgba(0,0,0,0.1)")
            }
        }
    }) {
        // Header row
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.FlexStart)
                gap(Spacing.md)
            }
        }) {
            Div(attrs = { style { property("flex", "1") } }) {
                H3(attrs = { classes(AppStyle.noteTitle) }) { Text(note.title) }
                P(attrs = { classes(AppStyle.noteMeta) }) {
                    Text("${note.date}  ·  ${note.tag.label}")
                }
            }
            // Tag badge
            Span(attrs = {
                val extra = when (note.tag) {
                    NoteTag.TECHNICAL -> AppStyle.noteTech
                    NoteTag.OBSERVATION -> AppStyle.noteObs
                    NoteTag.IDEA -> AppStyle.noteIdea
                    NoteTag.DRAFT -> AppStyle.noteDraft
                }
                classes(AppStyle.noteTag, extra)
                style { property("white-space", "nowrap") }
            }) { Text(note.tag.label) }
        }

        // Excerpt always visible
        P(attrs = { classes(AppStyle.noteExcerpt) }) { Text(note.excerpt) }

        // Expanded full body
        if (isExpanded) {
            P(attrs = { classes(AppStyle.noteBody) }) { Text(note.body) }
        } else {
            P(attrs = {
                style {
                    fontFamily(Font.mono)
                    fontSize(12.px)
                    color(Palette.primary)
                    marginTop(Spacing.md)
                    property("letter-spacing", "0.03em")
                }
            }) { Text("Click to read →") }
        }
    }
}

private val NoteTag.label: String
    get() = when (this) {
        NoteTag.TECHNICAL -> "Technical"
        NoteTag.OBSERVATION -> "Observation"
        NoteTag.IDEA -> "Idea"
        NoteTag.DRAFT -> "Draft"
    }
