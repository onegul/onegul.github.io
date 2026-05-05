package co.gul.ui.screen

import androidx.compose.runtime.*
import co.gul.model.content.NOTES
import co.gul.model.content.Note
import co.gul.model.content.NoteTag
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
fun NotebookScreen() {
    var expanded by remember { mutableStateOf<Int?>(null) }

    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            Header {
                SectionHeader(
                    heading = "Notebook",
                    subheading = "This is a diary for collecting random thoughts, observations and findings. I update this irregularly."
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
        }

        SiteFooter()
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
                    fontFamily(Font.MONO)
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
