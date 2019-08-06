package api.test.kotlin

import api.test.kotlin.models.GitHubUser
import org.apache.commons.lang3.RandomStringUtils
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.entity.ContentType
import org.apache.http.impl.client.HttpClientBuilder
import org.hamcrest.core.IsEqual.equalTo
import org.junit.Assert.assertThat
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertEquals


class GithubAPITest {
    @Test
    fun testAppHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test
    fun apiTest() {
        // Arrange
        val name = RandomStringUtils.randomAlphabetic(8)
        val request = HttpGet("https://api.github.com/users/$name")

        // Act
        val httpResponse = HttpClientBuilder.create().build().execute(request)

        // Assert
        assertEquals(
            httpResponse.statusLine.statusCode, HttpStatus.SC_NOT_FOUND
        )
    }

    @Test
    fun apiTest2() {
        // Arrange
        val request = HttpGet("https://api.github.com/users/skow0020")

        // Act
        val httpResponse = HttpClientBuilder.create().build().execute(request)

        // Assert
        assertThat(
            httpResponse.statusLine.statusCode,
            equalTo(HttpStatus.SC_OK)
        )

        val mimeType = ContentType.getOrDefault(httpResponse.entity).mimeType

        assertEquals("application/json", mimeType)
    }

    @Test
    fun apiTest3() {
        // Arrange
        val request = HttpGet("https://api.github.com/users/eugenp")

        // Act
        val httpResponse = HttpClientBuilder.create().build().execute(request)

        // Assert
        val resource = Utilities().retrieveResourceFromResponse(
            httpResponse, GitHubUser::class.java
        )

        assertEquals(resource.login, "eugenp")
    }
}
