package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.EmployeeService;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.service.ProjectService;
import com.dtu.firstreal.service.TransactionService;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.request.ProjectDetailDto;
import com.dtu.firstreal.service.dto.response.ProjectDetailDtoResponse;
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

//@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/detail")
public class ProjectDetailController {
    private static final Logger log = LoggerFactory.getLogger(ProjectDetailController.class);

    @Autowired
    ProjectDetailService projectDetailService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    ProjectService projectService;

    @Autowired
    TransactionService transactionService;

    @Autowired
    private Environment env;
    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllProjectDetail(){
        log.debug("Get all details");
        List<ProjectDetail> projectDetails = projectDetailService.findAllDetail();

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
            projectDetailDtoResponse.setState(projectDetail.isState());
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
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @GetMapping(value = "/getAll/project/{id}")
    public ResponseEntity<?> getAllDetailByProject(@PathVariable("id") String id){
        Project project = projectService.getOne(id);
        if(project == null){
            return new ResponseEntity<>("no project found",HttpStatus.NOT_FOUND);
        }else{
            List<ProjectDetail> projectDetails = projectDetailService.findAllByProjectId(id);
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
                projectDetailDtoResponse.setState(projectDetail.isState());
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
            if (projectDetails == null){
                return new ResponseEntity<>("no detail found by Project ",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/admin/getAll/project/{id}")
    public ResponseEntity<?> AdminGetAllDetailByProject(@PathVariable("id") String id){
        Project project = projectService.getOne(id);
        if(project == null){
            return new ResponseEntity<>("no project found",HttpStatus.NOT_FOUND);
        }else{
            List<ProjectDetail> projectDetails = projectDetailService.AdminFindAllByProjectId(id);
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
                projectDetailDtoResponse.setState(projectDetail.isState());
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
            if (projectDetails == null){
                return new ResponseEntity<>("no detail found by Project ",HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(responses, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getOne/{id}")
    public ResponseEntity<Object> getOneProjectDetail(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            ProjectDetailDtoResponse projectDetailDtoResponse = new ProjectDetailDtoResponse();
            ImageDto imageDto = new ImageDto();
            projectDetailDtoResponse.setImage(imageDto);
            projectDetailDtoResponse.setEmployeeId(projectDetail.getEmployee().getId());
            projectDetailDtoResponse.setProjectId(projectDetail.getProject().getId());
            projectDetailDtoResponse.setProjectName(projectDetail.getProject().getProjectName());
            projectDetailDtoResponse.setDirection(projectDetail.getDirection());
            projectDetailDtoResponse.setLocation(projectDetail.getLocation());
            projectDetailDtoResponse.setPrice(projectDetail.getPrice());
            projectDetailDtoResponse.setState(projectDetail.isState());
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
            return new ResponseEntity<>(projectDetailDtoResponse, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> createProjectDetails(@Valid @RequestBody ProjectDetailDto projectDetail){
        String projectDetailName = projectDetail.getProjectDetailName();
        if(projectDetailService.getOneByName(projectDetailName)!=null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(projectDetailService.createProject(projectDetail), HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Object> updateProjectDetails(@PathVariable("id") String id, @Valid @RequestBody ProjectDetailDto projectDetailForm){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if(projectDetail == null){
            return ResponseEntity.notFound().build();
        }else {
            String imageDirectory = env.getProperty("image.directory");
            String imageName = System.currentTimeMillis() +"" + new Random().nextInt() + "." + projectDetailForm.getImage().getType();
            projectDetail.setImageProjectDetailUrl(imageDirectory+imageName);
            projectDetail.setPrice(projectDetailForm.getPrice());
            projectDetail.setSize(projectDetailForm.getSize());
            projectDetail.setDirection(projectDetailForm.getDirection());
            projectDetail.setLocation(projectDetailForm.getLocation());
            projectDetail.setProjectDetailName(projectDetailForm.getProjectDetailName());
            BufferedImage img = null;
            try {
                img = ImageIO.read(new ByteArrayInputStream(Base64Utils.decodeFromString(projectDetailForm.getImage().getImage())))
                ;
                ImageIO.write(img, projectDetailForm.getImage().getType(), new FileOutputStream(projectDetail.getImageProjectDetailUrl()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            projectDetailService.save(projectDetail);
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteProjectDetails(@PathVariable("id") String id){
        ProjectDetail projectDetail = projectDetailService.getOne(id);
        if (projectDetail == null) {
            return ResponseEntity.notFound().build();
        }else{
            projectDetailService.delete(projectDetail);
//             transactionService.deleteByProjectDetail(projectDetail);
            return ResponseEntity.ok().build();
        }
    }
}
