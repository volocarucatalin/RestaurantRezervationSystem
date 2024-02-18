package com.vcakitchen.services;

import com.vcakitchen.repository.CustomerRepository;
import com.vcakitchen.request.CustomerRequest;
import com.vcakitchen.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service class is where all the logic is happening.
@Service
public class CustomerServices {
    private final CustomerRepository costumerRepository;

    @Autowired
    public CustomerServices(CustomerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    //This function is to create a customer
    public int createCostumer(CustomerRequest costumerRequest) {
        //Setting a Costumer
        Customer costumer = new Customer();
        costumer.setFirstName(costumerRequest.getFirstName());
        costumer.setLastName(costumerRequest.getLastName());
        costumer.setPhoneNumber(costumerRequest.getPhoneNumber());
        costumer.setNumOfP(costumerRequest.getNumOfP());
        costumer.setDate(costumerRequest.getDate());
        costumer.setTime(costumerRequest.getTime());

        //Making sure that the customer fallow the requirements and also making sure he doesn't do more bookings is one day.
        List<Customer> costumers = costumerRepository.findAll();
        if (costumers.size() != 0) {
            for (Customer cost : costumers) {
                if ((costumer.getFirstName().equals(cost.getFirstName())) && (costumer.getLastName().equals(cost.getLastName())) && (costumer.getPhoneNumber().equals(cost.getPhoneNumber()))) {
                    throw new RuntimeException("Costumer already exist");
                }

            }
        }

        if (costumer.getNumOfP() > 8) {
            throw new RuntimeException("Then number maxim of people is 8");
        }

        return costumerRepository.save(costumer).getCostumerID();
    }

    //Here we take all the customers from the DATABASE.
    public List<Customer> getAllCostumers() {
        return costumerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(){return costumerRepository.findById(1);}
}
