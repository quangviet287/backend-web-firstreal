package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.dto.request.EmployeeDto;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.response.EmployeeDtoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/employee/")
public class EmployeeController  {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @Autowired
    private Environment env;

    @GetMapping(value = "/getAll")
    public ResponseEntity<Object> getAllEmployees(){
        log.debug("Get all employees");

        List<Employee> employees =employeeService.findAllEmployee();
        List<EmployeeDtoResponse> responses = new ArrayList<>();
        for (Employee employee : employees){
            EmployeeDtoResponse employeeDtoResponse = new EmployeeDtoResponse();
            ImageDto imageDto = new ImageDto();
            employeeDtoResponse.setEmployeeId(employee.getId());
            employeeDtoResponse.setEmployeeName(employee.getEmployeeName());
            employeeDtoResponse.setAge(employee.getAge());
            employeeDtoResponse.setSex(employee.getSex());
            employeeDtoResponse.setImageProfileUrl(imageDto);
            employeeDtoResponse.setRoleId(employee.getRole().getId());
            employeeDtoResponse.setPhoneNumber(employee.getPhoneNumber());
            employeeDtoResponse.setUserName(employee.getUsername());
            employeeDtoResponse.setPassword(employee.getPassword());
            try{

                String imageType = employee.getImageProfileUrl().substring(employee.getImageProfileUrl().lastIndexOf(".")+1);
                BufferedImage originalImage =
                        ImageIO.read(new File(employee.getImageProfileUrl()));

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( originalImage, imageType, baos );
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                imageDto.setImage(Base64Utils.encodeToString(imageInByte));
                imageDto.setType(imageType);
                baos.close();

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            responses.add(employeeDtoResponse);
        }

        if(employees == null){
            return new ResponseEntity<>("employees not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
    @GetMapping(value = "/getOne/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createEmployee(@RequestBody EmployeeDto employee){
        String username = employee.getUserName();
        Employee emp = employeeService.getEmployeeByUserName(username);
        if(emp == null){
            employeeService.create(employee);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>("employee exits", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Employee> updateInfor(@PathVariable(value = "id") String id, @Valid @RequestBody EmployeeDto employeeForm){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        String imageDirectory = env.getProperty("image.directory");
        String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + employeeForm.getImageProfileUrl().getType();
        employee.setEmployeeName(employeeForm.getEmployeeName());
        employee.setPhoneNumber(employeeForm.getPhoneNumber());
        employee.setAge(employeeForm.getAge());
        employee.setImageProfileUrl(imageDirectory+imageName);
        employee.setUsername(employeeForm.getUserName());
        employee.setPassword(employeeForm.getPassword());
        employee.setSex(employeeForm.isSex());
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(employeeForm.getImageProfileUrl().getImage())))
            ;
            ImageIO.write(img, employeeForm.getImageProfileUrl().getType(), new FileOutputStream(employee.getImageProfileUrl()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        employeeService.save(employee);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        employeeService.delete(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/getOne/username/{username}")
    public ResponseEntity<Object> getEmployeeByUserName(@PathVariable("username") String username){
        Employee employee = employeeService.getEmployeeByUserName(username);
        if(employee == null){
            return new ResponseEntity<>("No employee found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
