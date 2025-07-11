package org.agrfesta.movies.iws.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import io.mockk.coVerify
import java.util.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TitlesController::class)
class TitlesControllerTest(
       @Autowired private val mockMvc: MockMvc,
       @Autowired private val objectMapper: ObjectMapper
) {
    private val titleId = UUID.randomUUID().toString()

    @Test fun `getTitle() Returns 400 when texts is empty`() {
        val responseBody: String = mockMvc.perform(
            get("/chunks"))
            .andExpect(status().isBadRequest)
            .andReturn().response.contentAsString

//        coVerify(exactly = 0) { embeddingsProvider.createEmbedding(any()) }
//        asserter.verifyNoTranslationsPersisted()
//        asserter.verifyNoEmbeddingsPersisted()
//        val response: MessageResponse = objectMapper.readValue(responseBody, MessageResponse::class.java)
//        response.message shouldBe "No chunks to create!"
    }

}
