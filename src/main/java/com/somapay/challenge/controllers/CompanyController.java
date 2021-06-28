package com.somapay.challenge.controllers;

import com.somapay.challenge.entities.Company;
import com.somapay.challenge.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company-api")
public class CompanyController {
    @Autowired
    private CompanyRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        this.repository.save(company);
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }

    @GetMapping("/get-account-balance/{id}")
    public ResponseEntity<Float> getAccountBalance(@PathVariable Integer id){
        Optional<Company> company = this.repository.findById(id);

        if(company.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("company with id %d not found", id));
        }

        return new ResponseEntity<Float>(company.get().getAccountBalance(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<Optional<Company>> getById(@PathVariable Integer id){
        Optional<Company> company = this.repository.findById(id);
        return new ResponseEntity<Optional<Company>>(company, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Company>> getAll(){
        List<Company> companyList = this.repository.findAll();
        return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
    }
}
