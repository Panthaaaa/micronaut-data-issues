package com.example

import io.micronaut.test.annotation.MicronautTest
import org.junit.jupiter.api.Test
import javax.inject.Inject

@MicronautTest
class ExampleTest {

    @Inject
    lateinit var exampleUserRepository: ExampleUserRepository

    @Test
    fun testItWorks() {
        exampleUserRepository.findByUserProfileFirstNameIlike("example").blockLast()
    }

}
