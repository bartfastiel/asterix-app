package com.example.asterixapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private CharacterRepository repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAsterixAndObelix_whenTheyAreStoredInDb() throws Exception {

        // given
        repo.save(new Character("1", "Asterix", "klein"));
        repo.save(new Character("2", "Idefix", "dick"));

        // when
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/characters")
        )

        // then
                .andExpect(
                        MockMvcResultMatchers.status().isOk()
                )
                .andExpect(
                        MockMvcResultMatchers.content().json("""
                        [
                            {
                                "id": "1",
                                "name": "Asterix",
                                "description": "klein"
                            },
                            {
                                "id": "2",
                                "name": "Idefix",
                                "description": "dick"
                            }
                        ]
""")
                )
        ;


    }

}























