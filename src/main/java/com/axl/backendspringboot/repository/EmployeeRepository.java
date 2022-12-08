package com.axl.backendspringboot.repository;

import com.axl.backendspringboot.model.Employee;
import lombok.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
