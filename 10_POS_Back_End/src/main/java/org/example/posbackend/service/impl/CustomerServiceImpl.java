package org.example.posbackend.service.impl;

import org.example.posbackend.Exception.CustomException;
import org.example.posbackend.dto.CustomerDto;
import org.example.posbackend.entity.CustomerEntity;
import org.example.posbackend.repository.CustomerRepository;
import org.example.posbackend.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        if(customerDto == null) {
            throw new NullPointerException("No data found to save");
        }
        if(customerRepository.existsById(customerDto.getId())) {
            throw new CustomException("Customer already exists");
        }
        customerRepository.save(modelMapper.map(customerDto, CustomerEntity.class));
        //throw new CustomException("Error while saving Customer Record");

    }

    @Override
    public void updateCustomer(CustomerDto customerDto) {
        if(customerDto == null) {
            throw new NullPointerException("No data found to update");
        }
//        if(customerRepository.existsById(customerDto.getId())) {
//            throw new CustomException("Customer already exists");
//        }

        customerRepository.save(modelMapper.map(customerDto, CustomerEntity.class));
    }

    @Override
    public void deleteCustomer(String id) {
        if(!customerRepository.existsById(id)) {
            throw new NullPointerException("Customer id is null");
        }

        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }


}
