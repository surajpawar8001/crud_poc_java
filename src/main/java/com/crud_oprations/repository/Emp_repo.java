package com.crud_oprations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud_oprations.entity.Employee;

@Repository
public interface Emp_repo extends JpaRepository<Employee, Integer> {

}
