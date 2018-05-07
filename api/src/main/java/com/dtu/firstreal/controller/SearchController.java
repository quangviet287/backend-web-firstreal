package com.dtu.firstreal.controller;

import com.dtu.firstreal.entity.ProjectDetail;
import com.dtu.firstreal.service.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    ProjectDetailService projectDetailService;

    @GetMapping(value = "/byPrice/{price}")
    public ResponseEntity<Object> getAllByPrice(@PathVariable("price") String price){
        List<ProjectDetail> details = projectDetailService.getAllByPrice(price);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping(value = "/bySize/{size}")
    public ResponseEntity<Object> getAllBySize(@PathVariable("size") int size){
        List<ProjectDetail> details = projectDetailService.getAllBySize(size);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping(value = "/byDirection/{direction}")
    public ResponseEntity<Object> getAllByDirection(@PathVariable("direction") String direction){
        List<ProjectDetail> details = projectDetailService.getAllByDirection(direction);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
        }return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping(value = "/bySizeDirectionPrice/{size}+{direction}+{price}")
    public ResponseEntity<Object> getAllBySizeAndDirectionAndPrice(@PathVariable("size") int size,
                                                                   @PathVariable("direction") String direction,
                                                                   @PathVariable("price") String price){
        List<ProjectDetail> details = projectDetailService.findAllBySizeAndDirectionAndPrice(size,direction,price);
        if(details == null){
            return new ResponseEntity<>("no detail found", HttpStatus.NOT_FOUND);
         }return new ResponseEntity<>(details, HttpStatus.OK);
    }
}
