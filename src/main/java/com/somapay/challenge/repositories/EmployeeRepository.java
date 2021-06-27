package com.somapay.challenge.repositories;

import com.somapay.challenge.entities.Company;
import com.somapay.challenge.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
