package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String>, CrudRepository<Employee, String> {
    List<Employee> findAll();
    Optional<Employee> findById(String id);
    Employee getOneByUsername(String userName);

    @Query(value = "select e from Employee e where e.username = :username and e.password = :password")
    Employee getOneUsernameAndPassword(String username, String password);

//    @Query(value = "select e from Employee e where e.username = :username")
//    Employee getOneByUsername(@PathVariable("username") String username);
}
