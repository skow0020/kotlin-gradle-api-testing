package api.test.kotlin.models

data class BookRqo(
    val title: String,
    val author: String,
    val backgroundImage: String,
    val category: String,
    val language: String? = null,
    val url: String,
    val pdf: String? =null,
    val body: String? = null
)