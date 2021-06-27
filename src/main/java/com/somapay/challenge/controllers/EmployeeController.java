package com.somapay.challenge.controllers;

import com.somapay.challenge.entities.Company;
import com.somapay.challenge.entities.Employee;
import com.somapay.challenge.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        this.repository.save(employee);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @GetMapping("/get-account-balance/{id}")
    public ResponseEntity<Float> getAccountBalance(@PathVariable Integer id){
        Optional<Employee> employee = this.repository.findById(id);

        if(employee.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("employee with id %d not found", id));
        }

        return new ResponseEntity<Float>(employee.get().getAccountBalance(), HttpStatus.OK);
    }
}
