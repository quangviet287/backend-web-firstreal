package com.dtu.firstreal.repository;

import com.dtu.firstreal.entity.Employee;
import com.dtu.firstreal.entity.Project;
import com.dtu.firstreal.entity.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectDetailRepository extends JpaRepository<ProjectDetail, String> {
    List<ProjectDetail> findAll();

    ProjectDetail getOne(String id);

    ProjectDetail getOneByProjectDetailName(String projectDetailName);

    @Query(value = "select p from ProjectDetail p where p.state=true")
    List<ProjectDetail> getAllByState();

    @Query(value = "select p from ProjectDetail p where p.state=true and p.employee = :employee")
    List<ProjectDetail> getAllByStateAndEmployee(@Param("employee") Employee employee);

    @Query(value = "select p from ProjectDetail p where p.employee = :employee")
    List<ProjectDetail> getAllEmployee(@Param("employee") Employee employee);

    List<ProjectDetail> getAllByDirection(String direction);

    @Query(value = "select p from ProjectDetail p where p.price <= :price")
    List<ProjectDetail> getAllByPrice(@Param("price") String price);

    @Query(value = "select p from ProjectDetail p where p.size <= :size")
    List<ProjectDetail> findAllBySize(@Param("size") int size);

    @Query(value = "select p from ProjectDetail p where p.size <= :size and p.direction = :direction and p.price <= :price")
    List<ProjectDetail> findAllBySizeAndDirectionAndPrice(@Param("size") int size,@Param("direction") String direction,@Param("price") String price);

    @Query(value = "select p from ProjectDetail p where p.project =:project")
    List<ProjectDetail> findAllByProject(@Param("project") Project project);
}
