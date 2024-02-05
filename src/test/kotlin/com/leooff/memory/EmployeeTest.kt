package com.leooff.memory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.leooff.memory.adapter.data.entities.Employee
import com.leooff.memory.adapter.input.controllers.EmployeeController
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.MediaType
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.web.context.WebApplicationContext
import java.time.LocalDate


class EmployeeTest : BaseIntegrationTest() {

    @Autowired
    private lateinit var context: WebApplicationContext


    @LocalServerPort
    private val port = 0

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Test
    fun testt() {

        val request = Employee(
            firstName = "Leonardo",
            dateOfBirth = LocalDate.now(),
            lastName = "Oliveira"
        )


        val response = restTemplate!!.postForEntity(
                "http://localhost:$port/employees", request, String::class.java
            )

    }
}