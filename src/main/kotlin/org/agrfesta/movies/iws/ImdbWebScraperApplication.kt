package org.agrfesta.movies.iws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ImdbWebScraperApplication

fun main(args: Array<String>) {
    runApplication<ImdbWebScraperApplication>(*args)
}
