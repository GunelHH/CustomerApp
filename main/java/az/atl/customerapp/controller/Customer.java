package az.atl.customerapp.controller;

import az.atl.customerapp.dto.CustomerDto;
import az.atl.customerapp.service.CustomerService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class Customer {
    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> createStudent(@RequestBody CustomerDto customerDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createcCustomer(customerDto));
    }
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto>findById(@NotNull @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findById(id));
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerDto>>findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findAllCustomers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void>updateStudent(@NotNull @PathVariable Long id,@RequestBody CustomerDto customerDto){
        customerService.updateCustomer(id,customerDto);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteStudent(@NotNull @PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
