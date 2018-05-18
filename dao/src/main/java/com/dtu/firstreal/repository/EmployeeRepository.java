package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String>, CrudRepository<Employee, String> {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    Employee getOneByUsername(String userName);

    @Query(value = "select e from Employee e where e.id = :id and e.username = :username and e.password = :password")
    Employee getOneByIdAndUsernameAndPassword(String id, String username, String password);

    @Query(value = "select e from Employee e where e.employeeName = :employeeName")
    Employee getOneByEmployeeName(@PathVariable("employeeName") String employeeName);
}
