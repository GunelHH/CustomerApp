package az.atl.customerapp.service.İmpl;

import az.atl.customerapp.dao.CustomerRepository;
import az.atl.customerapp.dto.CustomerDto;
import az.atl.customerapp.entity.Customer;
import az.atl.customerapp.exception.CustomerNotFoundException;
import az.atl.customerapp.mapper.CustomerMapper;
import az.atl.customerapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;
    @Override
    public CustomerDto createcCustomer(CustomerDto customerDto) {
        Customer customer=customerMapper.toEntity(customerDto);
        return  customerMapper.toDto(customerRepository.save(customer));
    }

    @Override
    public CustomerDto findById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(()->new CustomerNotFoundException("Customer not found with id "+id));
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {

//         customerRepository.findById(id)
//                .map((Function<Customer, Object>) customer -> customerMapper.toEntity(customerDto));
        Customer customer=customerMapper.toEntity(customerDto);

//        customer.setName(customerDto.getName());
//        customer.setLastName(customerDto.getLastName());
//        customer.setEmail(customerDto.getEmail());
//        customer.setCountry(customerDto.getCountry());
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .ifPresent(studentEntity -> customerRepository.deleteById(id));
    }
}
