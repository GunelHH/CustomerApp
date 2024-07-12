package az.atl.customerapp.service;

import az.atl.customerapp.dto.CustomerDto;
import az.atl.customerapp.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    CustomerDto createcCustomer(CustomerDto customerDto);
    CustomerDto findById(Long id);
    List<CustomerDto> findAllCustomers();

    void updateCustomer(Long id,CustomerDto customerDto);
    void deleteCustomer(Long id);
}
