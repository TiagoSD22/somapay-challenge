package com.somapay.challenge.controllers;

import com.somapay.challenge.entities.Company;
import com.somapay.challenge.entities.Employee;
import com.somapay.challenge.repositories.CompanyRepository;
import com.somapay.challenge.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee-api")
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private CompanyRepository companyRepository;

    @PostMapping("/create/{companyId}")
    public ResponseEntity<Employee> createEmployee(@PathVariable Integer companyId, @RequestBody Employee employee){
        Optional<Company> company = this.companyRepository.findById(companyId);

        if (company.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("company with id %d not found", companyId));
        }

        employee.setCompany(company.get());

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

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Optional<Employee>> getById(@PathVariable Integer id){
        Optional<Employee> employee = this.repository.findById(id);
        return new ResponseEntity<Optional<Employee>>(employee, HttpStatus.OK);
    }

    @GetMapping("/get-all-employees-by-company/{companyId}")
    public ResponseEntity<List<Employee>> getAllEmployeesByCompany(@PathVariable Integer companyId){
        List<Employee> companyEmployeeList = this.repository.findEmployeeByCompany(companyId);
        return new ResponseEntity<List<Employee>>(companyEmployeeList, HttpStatus.OK);
    }
}
