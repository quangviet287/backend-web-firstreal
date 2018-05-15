package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
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
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = "/byPrice/{price}")
    public ResponseEntity<Object> getAllByPrice(@PathVariable("price") String price){
        List<ProjectDetail> projectDetails = projectDetailService.getAllByPrice(price);
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
        }return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/bySize/{size}")
    public ResponseEntity<Object> getAllBySize(@PathVariable("size") int size){
        List<ProjectDetail> projectDetails = projectDetailService.getAllBySize(size);
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
        }return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/byDirection/{direction}")
    public ResponseEntity<Object> getAllByDirection(@PathVariable("direction") String direction){
        List<ProjectDetail> projectDetails = projectDetailService.getAllByDirection(direction);
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
        }return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping(value = "/bySizeDirectionPrice/{size}+{direction}+{price}")
    public ResponseEntity<Object> getAllBySizeAndDirectionAndPrice(@PathVariable("size") int size,
                                                                   @PathVariable("direction") String direction,
                                                                   @PathVariable("price") String price){
        List<ProjectDetail> projectDetails = projectDetailService.findAllBySizeAndDirectionAndPrice(size,direction,price);
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
         }return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
