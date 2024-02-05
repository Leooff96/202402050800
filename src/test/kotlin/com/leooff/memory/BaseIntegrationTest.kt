package com.leooff.memory

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc


@ContextConfiguration(initializers = [InitializerContainers::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BaseIntegrationTest {

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null


    private lateinit var mockMvc: MockMvc

    @Transactional
    protected fun cleanDB() {
        val tablesToTruncate = listOf("book").joinToString()
        val sql = """  
            SELECT 1
        """.trimIndent()
        jdbcTemplate?.execute(sql)
    }

}
