package api.test.kotlin

import com.fasterxml.jackson.module.kotlin.*
import org.apache.http.HttpResponse
import org.apache.http.util.EntityUtils
import java.io.IOException

class Utilities {
    @Throws(IOException::class)
    fun <T> retrieveResourceFromResponse(response: HttpResponse, clazz: Class<T>): T {

        val jsonFromResponse = EntityUtils.toString(response.entity)
        val mapper = jacksonObjectMapper()

        return mapper.readValue(jsonFromResponse, clazz)
    }
}