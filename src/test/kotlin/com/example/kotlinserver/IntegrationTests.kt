package com.example.kotlinserver

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension::class, MockitoExtension::class)
class IntegrationTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @BeforeEach
    internal fun setUp() {
        println("Setup")
    }

    @AfterEach
    internal fun tearDown() {
        println("TearDown")
    }

    @Test
    fun `test for test`() {
        assertEquals(4+1, 5)
    }

    @Test
    fun `Assert status code and content`() {
        mockMvc.get("/").andExpect {
            status { isOk() }
            content { "blog" }
        }
    }

    @Test
     fun `not found error page`() {
        mockMvc.get("/notFoundPage").andExpect {
            status { isNotFound() }
        }
    }


}