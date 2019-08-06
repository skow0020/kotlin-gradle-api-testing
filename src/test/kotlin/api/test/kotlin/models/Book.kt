package api.test.kotlin.models

data class Book(
    val _id: String,
    val title: String,
    val author: String,
    val backgroundImage: String,
    val category: String,
    val language: String? = null,
    val url: String,
    val pdf: String? =null,
    val body: String? = null,
    val book_id: Number,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val __v: Number? = null
)