package co.gul.ui.screen

import androidx.compose.runtime.*
import co.gul.model.content.BOOKS
import co.gul.model.content.Book
import co.gul.model.content.ReadStatus
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
fun LibraryScreen() {
    var filter by remember { mutableStateOf<ReadStatus?>(null) }

    val displayed = if (filter == null) BOOKS else BOOKS.filter { it.status == filter }

    Main {
        Article(attrs = { classes(AppStyle.sectionContainer) }) {
            Header {
                SectionHeader(
                    heading = "Library",
                    subheading = "Mostly Computer Science, Mathematics, Literature, Philosophy, and the occasional history. " +
                            "I love to read slowly and reread great books.."
                )
            }

            Divider()

            // Filter tabs
            Nav(attrs = {
                attr("aria-label", "Filter by reading status")
                style {
                    display(DisplayStyle.Flex)
                    gap(Spacing.sm)
                    marginBottom(Spacing.xl)
                    flexWrap(FlexWrap.Wrap)
                }
            }) {
                FilterButton("All (${BOOKS.size})", filter == null) { filter = null }
                FilterButton(
                    "Read (${BOOKS.count { it.status == ReadStatus.COMPLETED }})",
                    filter == ReadStatus.COMPLETED
                ) { filter = ReadStatus.COMPLETED }
                FilterButton(
                    "Reading (${BOOKS.count { it.status == ReadStatus.CURRENTLY_READING }})",
                    filter == ReadStatus.CURRENTLY_READING
                ) { filter = ReadStatus.CURRENTLY_READING }
                FilterButton(
                    "Will continue (${BOOKS.count { it.status == ReadStatus.WILL_FINISH }})",
                    filter == ReadStatus.WILL_FINISH
                ) { filter = ReadStatus.WILL_FINISH }
                FilterButton(
                    "Want to Read (${BOOKS.count { it.status == ReadStatus.WANT_TO_READ }})",
                    filter == ReadStatus.WANT_TO_READ
                ) { filter = ReadStatus.WANT_TO_READ }
            }

            // Book grid grouped by status when showing all
            if (filter == null) {
                BookSection("Currently Reading", BOOKS.filter { it.status == ReadStatus.CURRENTLY_READING })
                BookSection("Have Read", BOOKS.filter { it.status == ReadStatus.COMPLETED })
                BookSection("Will Continue", BOOKS.filter { it.status == ReadStatus.WILL_FINISH })
                BookSection("Want to Read", BOOKS.filter { it.status == ReadStatus.WANT_TO_READ })
            } else {
                Div(attrs = { classes(AppStyle.bookGrid) }) {
                    displayed.forEach { BookCard(it) }
                }
            }
        }

        SiteFooter()
    }
}

@Composable
private fun FilterButton(label: String, active: Boolean, onClick: () -> Unit) {
    Button(attrs = {
        if (active)
            classes(AppStyle.navLink, AppStyle.navLinkActive)
        else
            classes(AppStyle.navLink)
        onClick { onClick() }
        style { borderRadius(999.px) }
    }) { Text(label) }
}

@Composable
private fun BookSection(title: String, books: List<Book>) {
    if (books.isEmpty()) return

    H2(attrs = {
        style {
            fontFamily(Font.DISPLAY)
            fontSize(26.px)
            fontWeight(400)
            color(Palette.onSurface)
            property("letter-spacing", "-0.02em")
            marginBottom(Spacing.lg)
            marginTop(Spacing.xl)
        }
    }) { Text(title) }

    Div(attrs = { classes(AppStyle.bookGrid) }) {
        books.forEach { BookCard(it) }
    }

    Div(attrs = { style { marginTop(Spacing.xl) } }) {}
}

@Composable
private fun BookCard(book: Book) {
    Article(attrs = { classes(AppStyle.bookCard) }) {
        // Status badge
        Span(attrs = {
            val extra = when (book.status) {
                ReadStatus.COMPLETED -> AppStyle.statusRead
                ReadStatus.CURRENTLY_READING -> AppStyle.statusReading
                ReadStatus.WILL_FINISH -> AppStyle.statusReading
                ReadStatus.WANT_TO_READ -> AppStyle.statusWant
            }
            classes(AppStyle.bookStatus, extra)
        }) {
            Text(
                when (book.status) {
                    ReadStatus.COMPLETED -> "Read"
                    ReadStatus.CURRENTLY_READING -> "Reading now"
                    ReadStatus.WILL_FINISH -> "Will resume again"
                    ReadStatus.WANT_TO_READ -> "Want to read"
                }
            )
        }

        // Title & author
        H3(attrs = { classes(AppStyle.bookTitle) }) { Text(book.title) }
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                justifyContent(JustifyContent.SpaceBetween)
                alignItems(AlignItems.Center)
            }
        }) {
            P(attrs = { classes(AppStyle.bookAuthor) }) { Text(book.author) }
            Span(attrs = {
                style {
                    fontFamily(Font.MONO)
                    fontSize(11.px)
                    color(Palette.onSurfaceVariant)
                }
            }) { Text(book.readingPeriod) }
        }

        // Genre tag
        Span(attrs = {
            style {
                fontFamily(Font.MONO)
                fontSize(11.px)
                color(Palette.onSurfaceVariant)
                property("letter-spacing", "0.04em")
            }
        }) { Text(book.genre) }

        // Personal note
        P(attrs = { classes(AppStyle.bookNote) }) { Text("\"${book.note}\"") }
    }
}
