package com.somapay.challenge.repositories;

import com.somapay.challenge.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
