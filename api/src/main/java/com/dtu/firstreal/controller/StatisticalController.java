package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.response.ProjectDetailDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/statistical")
public class StatisticalController {
    @Autowired
    ProjectDetailService projectDetailService;

    @Autowired
    EmployeeService employeeService;
    @GetMapping(value = "/getAllSold")
    public ResponseEntity<Object> statisticalAllDetailSold(){
        List<ProjectDetail> projectDetails = projectDetailService.getByState();
        List<ProjectDetailDtoResponse> responses = new ArrayList<>();
        for (ProjectDetail projectDetail : projectDetails) {
            ProjectDetailDtoResponse projectDetailDtoResponse = new ProjectDetailDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectDetailDtoResponse.setImage(imageDto);
            projectDetailDtoResponse.setEmployeeId(projectDetail.getEmployee().getId());
            projectDetailDtoResponse.setProjectId(projectDetail.getProject().getId());
            projectDetailDtoResponse.setProjectName(projectDetail.getProject().getProjectName());
            projectDetailDtoResponse.setDirection(projectDetail.getDirection());
            projectDetailDtoResponse.setLocation(projectDetail.getLocation());
            projectDetailDtoResponse.setPrice(projectDetail.getPrice());
            projectDetailDtoResponse.setSate(projectDetail.isState());
            projectDetailDtoResponse.setSize(projectDetail.getSize());
            projectDetailDtoResponse.setProjectDetailName(projectDetail.getProjectDetailName());
            projectDetailDtoResponse.setProjectDetailId(projectDetail.getId());
            try{
                String imageType = projectDetail.getImageProjectDetailUrl().substring(projectDetail.getImageProjectDetailUrl().lastIndexOf(".")+1);
                BufferedImage originalImage =
                        ImageIO.read(new File(projectDetail.getImageProjectDetailUrl()));

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
            responses.add(projectDetailDtoResponse);
        }
        if(projectDetails == null){
            return ResponseEntity.notFound().build();
        }else return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/getAllSoldByEmployee/{id}")
    public ResponseEntity<Object> statisticalDetailSoldByEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        List<ProjectDetail> projectDetails = projectDetailService.getAllSoldByEmployee(employee);
        List<ProjectDetailDtoResponse> responses = new ArrayList<>();
        for (ProjectDetail projectDetail : projectDetails) {
            ProjectDetailDtoResponse projectDetailDtoResponse = new ProjectDetailDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectDetailDtoResponse.setImage(imageDto);
            projectDetailDtoResponse.setEmployeeId(projectDetail.getEmployee().getId());
            projectDetailDtoResponse.setProjectId(projectDetail.getProject().getId());
            projectDetailDtoResponse.setProjectName(projectDetail.getProject().getProjectName());
            projectDetailDtoResponse.setDirection(projectDetail.getDirection());
            projectDetailDtoResponse.setLocation(projectDetail.getLocation());
            projectDetailDtoResponse.setPrice(projectDetail.getPrice());
            projectDetailDtoResponse.setSate(projectDetail.isState());
            projectDetailDtoResponse.setSize(projectDetail.getSize());
            projectDetailDtoResponse.setProjectDetailName(projectDetail.getProjectDetailName());
            projectDetailDtoResponse.setProjectDetailId(projectDetail.getId());
            try{
                String imageType = projectDetail.getImageProjectDetailUrl().substring(projectDetail.getImageProjectDetailUrl().lastIndexOf(".")+1);
                BufferedImage originalImage =
                        ImageIO.read(new File(projectDetail.getImageProjectDetailUrl()));

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
            responses.add(projectDetailDtoResponse);
        }


        if(projectDetails == null){
            return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(responses,HttpStatus.OK);
    }
    @GetMapping(value = "/getAllByEmployee/{id}")
    public ResponseEntity<Object> statisticalAllDetailByEmployee(@PathVariable("id") String id){
        Employee employee = employeeService.findEmployeeById(id);
        List<ProjectDetail> projectDetails = projectDetailService.getAllByEmployee(employee);
        List<ProjectDetailDtoResponse> responses = new ArrayList<>();
        for (ProjectDetail projectDetail : projectDetails) {
            ProjectDetailDtoResponse projectDetailDtoResponse = new ProjectDetailDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectDetailDtoResponse.setImage(imageDto);
            projectDetailDtoResponse.setEmployeeId(projectDetail.getEmployee().getId());
            projectDetailDtoResponse.setProjectId(projectDetail.getProject().getId());
            projectDetailDtoResponse.setProjectName(projectDetail.getProject().getProjectName());
            projectDetailDtoResponse.setDirection(projectDetail.getDirection());
            projectDetailDtoResponse.setLocation(projectDetail.getLocation());
            projectDetailDtoResponse.setPrice(projectDetail.getPrice());
            projectDetailDtoResponse.setSate(projectDetail.isState());
            projectDetailDtoResponse.setSize(projectDetail.getSize());
            projectDetailDtoResponse.setProjectDetailName(projectDetail.getProjectDetailName());
            projectDetailDtoResponse.setProjectDetailId(projectDetail.getId());
            try{
                String imageType = projectDetail.getImageProjectDetailUrl().substring(projectDetail.getImageProjectDetailUrl().lastIndexOf(".")+1);
                BufferedImage originalImage =
                        ImageIO.read(new File(projectDetail.getImageProjectDetailUrl()));

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
            responses.add(projectDetailDtoResponse);
        }
        if(projectDetails == null){
            return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
        }else return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}
