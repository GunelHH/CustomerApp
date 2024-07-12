package az.atl.customerapp.dao;

import az.atl.customerapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
