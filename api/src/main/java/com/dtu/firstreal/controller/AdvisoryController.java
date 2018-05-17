package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.service.dto.request.ImageDto;
import com.dtu.firstreal.service.dto.response.ProjectDetailDtoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
@RequestMapping(value = "/advisory")
public class AdvisoryController {

    @Autowired
    ProjectDetailService projectDetailService;

    @Autowired
    private Environment env;

    @GetMapping(value = "/{age}+{sex}")
    public ResponseEntity<Object> getDetailsByDirection(@PathVariable("age") String age, @PathVariable("sex") Boolean sex){
        String direction;

        if(age.equals("Ty") && sex.equals(true)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Ty") && sex.equals(true)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Suu") && sex.equals(true)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Suu") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Dan") && sex.equals(true)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Dan") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Meo") && sex.equals(true)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Meo") && sex.equals(false)){
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Thin") && sex.equals(true)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Thin") && sex.equals(false)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Ti") && sex.equals(false)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Ti") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Ngo") && sex.equals(false)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Ngo") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Mui") && sex.equals(false)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Mui") && sex.equals(false)){
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Than") && sex.equals(false)){
            direction = "Dong";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Than") && sex.equals(false)){
            direction = "Dong Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Dau") && sex.equals(false)){
            direction = "Dong Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Dau") && sex.equals(false)){
            direction = "Tay";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Tuat") && sex.equals(false)){
            direction = "Tay Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Tuat") && sex.equals(false)){
            direction = "Tay Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else if(age.equals("Hoi") && sex.equals(false)){
            direction = "Nam";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }else{
            direction = "Bac";
            List<ProjectDetail> lists = projectDetailService.getAllByDirection(direction);
            if(lists == null){
                return new ResponseEntity<>("No details found", HttpStatus.NOT_FOUND);
            }
            else{
                List<ProjectDetailDtoResponse> responses = getAllDetail(lists);
                return new ResponseEntity<>(responses, HttpStatus.OK);
            }
        }
    }
    private List<ProjectDetailDtoResponse> getAllDetail(List<ProjectDetail> lists){
        List<ProjectDetailDtoResponse> responses = new ArrayList<>();
        for (ProjectDetail projectDetail : lists) {
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
        return responses;
    }
}
