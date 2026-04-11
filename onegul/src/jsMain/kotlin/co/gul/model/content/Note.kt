package co.gul.model.content

data class Note(
    val title: String,
    val date: String,
    val tag: NoteTag,
    val excerpt: String,
    val body: String
)

enum class NoteTag { TECHNICAL, OBSERVATION, IDEA, DRAFT }

val NOTES = listOf(
    Note(
        "Persuasion and Imposture",
        "March 2025",
        NoteTag.OBSERVATION,
        "Most of the times when you try to convince someone, it ends up doing the opposite of the intended effect. People recognize genuine passion instinctively.",
        """There's something intrinsically natural about passion that makes other people believe you.
There's inherently artificial about persuasive language unless it's backed by something substantial.
Persuasive posture is just refined imposture. People abhor such refined complexity and sophistication and their embodied cognition picks up on that.
Persuasive language in itself is bogus and during projection it lacks substance.
"""
    )
)
