package api.test.kotlin.models

data class Books(
    val success: Boolean,
    val data: Collection<Book>
)