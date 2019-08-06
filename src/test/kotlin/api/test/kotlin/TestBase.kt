package api.test.kotlin

import com.fasterxml.jackson.module.kotlin.*

open class TestBase {
    val baseUrl = "https://tap-library-dev.herokuapp.com/api"
    val mapper = jacksonObjectMapper()

}