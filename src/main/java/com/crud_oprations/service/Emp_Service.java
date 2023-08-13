package com.crud_oprations.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud_oprations.entity.Employee;
import com.crud_oprations.repository.Emp_repo;

@Service
public class Emp_Service {

	@Autowired
	private Emp_repo repo;

	public void addemp(Employee e) {
		repo.save(e);

	}

	public List<Employee> getallemp() {

		return repo.findAll();
	}

	public Employee getempbyid(int id) {

		Optional<Employee> e = repo.findById(id);
		if (e.isPresent()) {
			return e.get();
		}
		return null;

	}

	public void deleteemp(int id) {
		repo.deleteById(id);
	}

}
