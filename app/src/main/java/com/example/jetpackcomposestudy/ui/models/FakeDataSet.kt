package com.example.jetpackcomposestudy.ui.models

const val LOREM_IPSUM = "Lorem Ipsum is simply dummy text of the printing and typesetting " +
        "industry. Lorem Ipsum has been the industrys standard dummy text ever " +
        "since the 1500s, when an unknown printer took a galley of type and " +
        "scrambled it to make a type specimen book. It has survived not only " +
        "five centuries, but also the leap into electronic typesetting, remaining " +
        "essentially unchanged. It was popularised in the 1960s with the release of " +
        "Letraset sheets containing Lorem Ipsum passages, and more recently with " +
        "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."

val FAKE_DATABASE = listOf<PostItemModel>(
    PostItemModel(
        author = "John Doe_1",
        title = "Some awesome news #1",
        text = LOREM_IPSUM,
        date = "5 days ago"
    ),
    PostItemModel(
        author = "John Doe_2",
        title = "Amazing news",
        text = LOREM_IPSUM,
        date = "1 day ago"
    )
)