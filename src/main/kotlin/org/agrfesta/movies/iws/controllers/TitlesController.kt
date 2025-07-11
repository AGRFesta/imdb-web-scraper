package org.agrfesta.movies.iws.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/titles")
class TitlesController {

    @GetMapping("/{id}")
    fun getTitle(@PathVariable id: String): ResponseEntity<Any> {
        return ResponseEntity.ok("OK")
    }

}
