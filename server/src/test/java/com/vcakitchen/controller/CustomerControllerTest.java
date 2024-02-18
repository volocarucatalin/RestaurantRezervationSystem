package com.vcakitchen.controller;

import com.vcakitchen.request.CustomerRequest;
import com.vcakitchen.response.CustomerResponse;
import com.vcakitchen.response.CustomersResponse;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class CustomerControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Order(1)
    @Test
    public void testCreateCustomer() {
        HttpEntity<CustomerRequest> request = new HttpEntity<>(new CustomerRequest("Sandel","Volocaru","074353",8), new HttpHeaders());
        CustomerResponse expected = new CustomerResponse(1);
        ResponseEntity<CustomerResponse> response = restTemplate.exchange(createURLWithPort("/customers/add"), HttpMethod.POST, request, CustomerResponse.class);
        CustomerResponse actual = response.getBody();
        assert actual != null;
        assertEquals(actual.getId(), expected.getId());
    }

    @Order(2)
    @Test
    public void testGetAllCostumers() {
        HttpEntity<CustomerRequest> request1 = new HttpEntity<>(new CustomerRequest("cATALIN","Volocaru","074352",8), new HttpHeaders());
        HttpEntity<CustomerRequest> request2 = new HttpEntity<>(new CustomerRequest("Denis","dasda","0980948",3), new HttpHeaders());
        HttpEntity<CustomerRequest> request3 = new HttpEntity<>(new CustomerRequest("Sergiu","dddddd","07463725",3), new HttpHeaders());

        ResponseEntity<CustomerResponse> response1 = restTemplate.exchange(createURLWithPort("/customers/add"), HttpMethod.POST, request1, CustomerResponse.class);
        ResponseEntity<CustomerResponse> response2 = restTemplate.exchange(createURLWithPort("/customers/add"), HttpMethod.POST, request2, CustomerResponse.class);
        ResponseEntity<CustomerResponse> response3 = restTemplate.exchange(createURLWithPort("/customers/add"), HttpMethod.POST, request3, CustomerResponse.class);
        ResponseEntity<CustomersResponse[]> costumers = restTemplate.exchange(createURLWithPort("/customers/get"),HttpMethod.GET,null,CustomersResponse[].class);
        int expected = 3;


        assertEquals(expected,costumers.getBody().length);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
