package io.github.rcvaram.mediumlogapp.Customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {
    public Customer findCustomer(long id) {
        if (id == 10) {
            throw new RuntimeException("Invalid Customer Id");
        }
        return new Customer(String.valueOf(id), "Sivaram", "cvaram96@gmail.com", true);
    }
}
