package com.example.demo;


import com.example.demo.sawmill.Sawmill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SawmillControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testGetSawmillById(){
        ResponseEntity<Sawmill> response = testRestTemplate.getForEntity(
                "/api/v1/sawmill/1",
                Sawmill.class);

        assertEquals(1,response.getBody().getId());
        assertEquals("Asma",response.getBody().getName());
        assertEquals("Damascus",response.getBody().getCity());
        assertEquals("Syria",response.getBody().getCountry());
    }

    @Test
    public void testRegisterNewSawmill() {
        Sawmill sawmill = new Sawmill("Malaz", "Daoha", "Qatar");
        ResponseEntity<String> responseEntity = this.testRestTemplate
                .postForEntity("/api/v1/sawmill", sawmill, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

}
