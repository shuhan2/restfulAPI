package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByCompanyName(String name);


}
