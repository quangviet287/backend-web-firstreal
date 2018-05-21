package com.dtu.firstreal.service.Impl;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.Role;
import com.dtu.firstreal.repository.EmployeeRepository;
import com.dtu.firstreal.repository.RoleRepository;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.dto.request.EmployeeDto;
import com.dtu.firstreal.service.dto.response.EmployeeResponse;
import com.dtu.firstreal.service.exception.RoleNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);


    @Autowired
    private EmployeeRepository employeeRepository;
    @Value("${image.directory}")
    private String imageDirectory;

    @Autowired
    private Environment env;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeeById(String id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeById(Employee employee) {
//        employee = employeeRepository.findById(id).get();
        employeeRepository.save(employee);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
         employeeRepository.delete(employee);
    }

    @Override
    public Employee getEmployeeByUserName(String username) {
        return (Employee) employeeRepository.getOneByUsername(username);
    }

    @Override
    public Employee getEmployeeByUsernameAndPassword(String username, String password) {
        return employeeRepository.getOneByUsernameAndPassword(username,password);
    }

    @Override
    public EmployeeResponse create(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        String imageDirectory = getImageDirectory();
        Role role = roleRepository.findById(employeeDto.getRoleId()).orElseThrow(()-> new RoleNotFoundException());
        String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + employeeDto.getImageProfileUrl().getType();
        employee.setRole(role);
        employee.setAge(employeeDto.getAge());
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setImageProfileUrl(imageDirectory+imageName);
        employee.setSex(employeeDto.isSex());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setUsername(employeeDto.getUserName());
        employee.setPassword(employeeDto.getPassword());
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(employeeDto.getImageProfileUrl().getImage())))
            ;
            ImageIO.write(img, employeeDto.getImageProfileUrl().getType(), new FileOutputStream(employee.getImageProfileUrl()));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        employee = employeeRepository.save(employee);
        return new EmployeeResponse(employee.getId());
    }

    @Override
    public Employee getOneByName(String employeeName) {
        return employeeRepository.getOneByUsername(employeeName);
    }

    private String getImageDirectory() {
        return env.getProperty("image.directory");
    }
}
