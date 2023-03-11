package com.Springboot.Service;

import com.Springboot.Entity.Department;
import com.Springboot.Repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

    public Department getDepartmentsbyID(Long departmentId) throws Exception;

    public void deleteRecords(Long departmentId);

    public Department UpdateDepartment(Long departmentId, Department department);

    public Department getDataByName(String departmentName);
}
