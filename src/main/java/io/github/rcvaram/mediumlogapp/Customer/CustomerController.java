package io.github.rcvaram.mediumlogapp.Customer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    @Operation(summary = "Customer GET endpoint",
            parameters = {
                    @Parameter(
                            name = "correlationId",
                            in = ParameterIn.HEADER,
                            required = false,
                            description = "Correlation ID for tracking",
                            schema = @Schema(type = "string")
                    )
            }
    )
    public Customer findCustomer(@PathVariable long id) {
        log.info("Request is received for customer Id : {}", id);
        Customer customer = customerService.findCustomer(id);
        log.info("Customer : {} detail sent", customer);
        return customer;
    }
}
