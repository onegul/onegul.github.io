package co.gul.model.content

data class Book(
    val title: String,
    val author: String,
    val readingPeriod: String,
    val genre: String,
    val note: String,
    val status: ReadStatus
)

enum class ReadStatus {
    COMPLETED,
    CURRENTLY_READING,
    WILL_FINISH,
    WANT_TO_READ
}

val BOOKS = listOf(
    Book(
        "Introduction to Algorithms", "CLRS", "2022", "Computer Science",
        "You only need two books to learn Algorithms, first is CLRS and the other one is Algorithm Design.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Algorithm Design", "Kleinblerg, Tardos", "2016", "Computer Science",
        "Best book to learn how to approach and go about solving problems algorithmically",
        ReadStatus.COMPLETED
    ),
    Book(
        "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "2021", "Software Engineering",
        "I read this book a long time ago. Having worked on multiple legacy Android apps, I've learnt how to improve the maintainability codebases and importantly keep the codebase fresh. This book explains Clean Architecture in detail.",
        ReadStatus.COMPLETED
    ),
    Book(
        "The Pragmatic Programmer", "Andy Hunt & Dave Thomas", "2019", "Software Engineering",
        "A lot of it is pretty basic for programmers with a few years of experience, but still good for someone who is not exposed to code standards.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Hacker's Delight", "Henry S. Warren Jr.", "2022", "Low-Level Programming",
        "A collection of clever bit-level programming hacks.",
        ReadStatus.WILL_FINISH
    ),
    Book(
        "Thinking, Fast and Slow", "Daniel Kahneman", "2018", "Psychology",
        "Liked it when I read it in college, but now it just feels like something that doesn't replicate under real-world experiments.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Meditations", "Marcus Aurelius", "2019", "Classical Philosophy",
        "Learnt a lot about dealing with my vices and developing character traits.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Zero to One: Notes on Startups", "Peter Thiel", "2018", "Business",
        "Always used to love the reasoning behind Thiel's views",
        ReadStatus.COMPLETED
    ),
    Book(
        "Hackers & Painters: Big Ideas from the Computer Age", "Paul Graham", "2019", "Philosophy",
        "I guess everyone in programming and startups had a phase where they got to know the writings of Paul Graham.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Deep Work: Rules for Focused Success", "Cal Newport", "2017", "Productivity",
        "Best to follow what your curiosity and do what you really want to do, rather than forcing to do things you don't want with these bullshit deep work techniques.",
        ReadStatus.COMPLETED
    ),
    Book(
        "The Soul of a New Machine", "Tracy Kidder", "2019", "History of Technology",
        "A great story about the internals of how companies and teams worked to build computers at the outset of personal computer era.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Siddhartha", "Hermann Hesse", "2019", "Philosophy",
        "Read it when I left college and was wandering in the streets of Delhi. Still remember the incident described in the book when Siddhartha explains the first time he saw Budha",
        ReadStatus.COMPLETED
    ),
    Book(
        "The Prophet", "Kahlil Gibran", "2019", "Philosophy",
        "Read it a long time back.",
        ReadStatus.COMPLETED
    ),
    Book(
        "Influence: The Psychology of Persuasion", "Robert Cialdini", "2019", "Psychology",
        "A lot of it has already been written long time back and that too in greater depth and breadth.",
        ReadStatus.COMPLETED
    ),
    Book(
        "A New Kind of Science", "Stephen Wolfram", "2018", "Computer Science",
        "Wolfram explains that the complexity of the universe can be explained through simple computational rules and cellular automata.",
        ReadStatus.COMPLETED
    ),
    Book(
        "The Way of the Superior Man", "David Deida", "2019", "Philosophy",
        "A lot of good things to learn from this book.",
        ReadStatus.COMPLETED
    )
)