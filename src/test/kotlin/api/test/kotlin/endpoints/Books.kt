package api.test.kotlin.endpoints

import api.test.kotlin.TestBase
import api.test.kotlin.Utilities
import api.test.kotlin.models.BookPostRpo
import api.test.kotlin.models.BookRqo
import api.test.kotlin.models.Books
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClientBuilder
import kotlin.test.Test
import kotlin.test.assertEquals

class Books : TestBase() {
    @Test
    fun getBooks() {
        // Arrange
        val request = HttpGet("$baseUrl/books")

        // Act
        val httpResponse = HttpClientBuilder.create().build().execute(request)

        // Assert
        val resource = Utilities().retrieveResourceFromResponse(
            httpResponse, Books::class.java
        )

        assertEquals(resource.success, true)
    }

    @Test
    fun postBook() {
        // Arrange
        var bookRqo = BookRqo(
            "BOOK TITLE",
            "Book author",
            "backgroundimage.com",
            "General",
            "Python",
            "www.url.com",
            "body is here woooop"
        )
        var bookRqoJson = mapper.writeValueAsString(bookRqo)

        val request = HttpPost("$baseUrl/books")
        request.setEntity(StringEntity(bookRqoJson));
        request.addHeader("Content-Type", "application/json");

        // Act
        val httpResponse = HttpClientBuilder.create().build().execute(request)

        // Assert
        val resource = Utilities().retrieveResourceFromResponse(
            httpResponse, BookPostRpo::class.java
        )

        assertEquals(resource.success, true)
        assertEquals(resource.post.title, "BOOK TITLE")
    }
}