package com.techgeeknext.repository.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techgeeknext.entities.company.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
