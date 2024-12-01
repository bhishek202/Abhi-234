package com.airbnb;

import com.airbnb.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

  Optional<Employee> findByName(String name);

  Optional<Employee> findByEmail(String email);

  Optional<Employee> findByMobile(String mobile);

  Optional<Employee> findByPassword(String password);
}