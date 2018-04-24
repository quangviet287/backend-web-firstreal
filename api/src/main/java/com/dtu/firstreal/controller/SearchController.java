package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
import com.dtu.firstreal.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_PRICE)
    public ResponseEntity<Object> getAllByPrice(@PathVariable("price") String price){
        List<ProjectDetail> details = projectDetailService.getAllByPrice(price);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_SIZE)
    public ResponseEntity<Object> getAllBySize(@PathVariable("size") int size){
        List<ProjectDetail> details = projectDetailService.getAllBySize(size);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping(value = Constants.URI_PROJECT_DETAIL_SEARCH)
    public ResponseEntity<Object> getAllBySizeAndDirectionAndPrice(@PathVariable("size") int size,
                                                                   @PathVariable("direction") String direction,
                                                                   @PathVariable("price") String price){
        List<ProjectDetail> details = projectDetailService.findAllBySizeAndDirectionAndPrice(size,direction,price);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
         }return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
