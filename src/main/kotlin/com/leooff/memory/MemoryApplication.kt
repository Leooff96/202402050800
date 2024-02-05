package com.leooff.memory

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MemoryApplication

fun main(args: Array<String>) {
    runApplication<MemoryApplication>(*args)
}
