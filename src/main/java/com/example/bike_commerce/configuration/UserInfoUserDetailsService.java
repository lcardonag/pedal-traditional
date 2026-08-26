package com.example.bike_commerce.configuration;

import com.example.bike_commerce.customers.entities.Customer;
import com.example.bike_commerce.customers.repositories.CustomerRepository;
import com.example.bike_commerce.employees.entities.Employees;
import com.example.bike_commerce.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService  implements UserDetailsService {
    @Autowired
    private EmployeeRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> userInfo = customerRepository.findUserByUsername(username);

        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}

