package co.gul.model.content

/**
 * A data model representation of a bookmark.
 */
data class Bookmark(
    val title: String,
    val description: String,
    val url: String,
    val type: BookMarkType,
    val status: BookmarkStatus
)

enum class BookMarkType {
    BLOG_POST,
    BOOK
}

enum class BookmarkStatus {
    WILL_READ,
    READING,
    READ
}

val BOOKMARKS = listOf(
    Bookmark(
        title = "Binder in Android",
        description = """
            Dianne Hackborn's explanation of how the Binder is used in Android. He was one of key developers in OpenBinder's team. He later joined Android and worked on the implementation of Binder in Android.
        """.trimIndent(),
        url = """https://lkml.org/lkml/2009/6/25/3""",
        type = BookMarkType.BLOG_POST,
        status = BookmarkStatus.READING
    )
)