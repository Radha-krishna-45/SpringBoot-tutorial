package com.Springboot.Controller;


import com.Springboot.Entity.Department;
import com.Springboot.Service.DepartmentService;
import com.Springboot.Service.DepartmentServiceIImplementation;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        logger.info("we hit the post request. Data is saved in the records");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentsList() {
        logger.info("get request hit, so we get the data");
        return departmentService.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws Exception {
        return departmentService.getDepartmentsbyID(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteByID(@PathVariable("id") Long departmentId) {
        departmentService.deleteRecords(departmentId);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.UpdateDepartment(departmentId, department);

    }

    @GetMapping("/departments/departmentName/{name}")
    public Department departmentDataByName(@PathVariable("name") String departmentName) {
        return departmentService.getDataByName(departmentName);

    }

}
