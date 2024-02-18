package com.vcakitchen.integrationtest;

import com.vcakitchen.entity.Customer;
import com.vcakitchen.repository.CustomerRepository;
import com.vcakitchen.request.CustomerRequest;
import com.vcakitchen.response.CustomerResponse;
import com.vcakitchen.services.CustomerServices;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerIntegrationTest {

    @Autowired
    CustomerRepository customerRepository;




    @Autowired
    TestEntityManager testEntityManager;


    Customer customer = new Customer();
    Customer customer2 = new Customer();
    Customer customer3 = new Customer();



    @Test
    public  void testCreateCustomer(){
        customerRepository.save(customer);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        Assert.assertEquals(3,customerRepository.count());


    }

    @Test(expected = RuntimeException.class)
    public void testCreateCustomerResponseCustomerAlreadyExist(){
        CustomerServices customerServices = new CustomerServices(customerRepository);
        CustomerRequest customer = new CustomerRequest();
        customer.setFirstName("Catalin");
        customer.setLastName("Volocaru");
        customer.setPhoneNumber("07497353550");
        customer.setNumOfP(8);
        customerServices.createCostumer(customer);

        CustomerRequest customer1 = new CustomerRequest();
        customer1.setFirstName("Catalin");
        customer1.setLastName("Volocaru");
        customer1.setPhoneNumber("07497353550");
        customer1.setNumOfP(8);

        Assert.assertEquals(customerServices.createCostumer(customer1),new RuntimeException("Costumer already exist"));




    }
    @Test(expected = RuntimeException.class)
    public void testCreateCustomerThenNumberMaximOfPeopleIs8(){
        CustomerServices customerServices = new CustomerServices(customerRepository);
        CustomerRequest customer = new CustomerRequest();
        customer.setFirstName("Catalin");
        customer.setLastName("Volocaru");
        customer.setPhoneNumber("07497353550");
        customer.setNumOfP(9);

        Assert.assertEquals(customerServices.createCostumer(customer),new RuntimeException("Then number maxim of people is 8"));

    }

}
