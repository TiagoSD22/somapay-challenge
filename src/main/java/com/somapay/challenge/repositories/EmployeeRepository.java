package com.somapay.challenge.repositories;

import com.somapay.challenge.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e where e.company.id = ?1")
    List<Employee> findEmployeeByCompany(Integer companyId);
}
