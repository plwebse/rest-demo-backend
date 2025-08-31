package se.plweb.rest_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getAll() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/customers", List.class)).isNotEmpty();
    }

    @Test
    void add() {

        Customer customer = new Customer("name1unit", "address1", "email1", "070");

        this.restTemplate.postForEntity("http://localhost:" + port + "/customers", customer, Customer.class);

        assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/customers", List.class)
                .toString().contains(customer.getName()));


    }
}