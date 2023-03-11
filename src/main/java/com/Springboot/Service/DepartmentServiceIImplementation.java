package com.Springboot.Service;

import com.Springboot.Entity.Department;
import com.Springboot.Error.DepartmentNotFoundException;
import com.Springboot.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceIImplementation implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentsbyID(Long departmentId) throws Exception {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);

        if (!departmentOptional.isPresent()) {
            throw new DepartmentNotFoundException("Department not found");
        }
        return departmentOptional.get();
    }

    @Override
    public void deleteRecords(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department UpdateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department1.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            department1.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department1.getAddress()) && !"".equalsIgnoreCase(department.getAddress())) {
            department1.setAddress(department.getAddress());
        }

        if (Objects.nonNull(department1.getCompany()) && !"".equalsIgnoreCase(department.getCompany())) {
            department1.setCompany(department.getCompany());
        }

        return departmentRepository.save(department1);
    }

    @Override
    public Department getDataByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);

    }
}

