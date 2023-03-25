package com.Springboot.Service;

import com.Springboot.Entity.Department;
import com.Springboot.Repository.DepartmentRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class DepartmentServiceIImplementationTest {

    @Mock
    DepartmentRepository departmentRepository;

    @InjectMocks
    DepartmentServiceIImplementation departmentServiceIImplementation;


    @Test
    void saveDepartmentTest() {
        Department department1 = new Department();
        department1.setDepartmentName("IT");

        when(departmentRepository.save(department1)).thenReturn(department1);

        Department department2 = departmentServiceIImplementation.saveDepartment(department1);
        assertNotNull(department2);
        assertEquals(department1.getDepartmentName(), department2.getDepartmentName());

        verify(departmentRepository, times(1)).save(department2);

    }

    @Test
    void getDepartmentsTest() {
        Department department = new Department();
        department.setDepartmentName("IT");
        department.setCompany("SPP");
        department.setAddress("AR");
        department.setId(45L);

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);

        when(departmentRepository.findAll()).thenReturn(departmentList);

        List<Department> result = departmentServiceIImplementation.getDepartments();

        assertEquals(departmentList, result);
    }

    @Test
    void getDepartmentsReturns_EmptyListTest() {

        when(departmentRepository.findAll()).thenReturn(Collections.emptyList());

        List<Department> result = departmentServiceIImplementation.getDepartments();

        assertNotNull(result);
        assertEquals(0, result.size());

        verify(departmentRepository, times(1)).findAll();

    }

    @Test
    void getDepartmentsbyIDTest() throws Exception {
        long departmentId = 45L;

        Department department = new Department();
        department.setDepartmentName("IT");
        department.setCompany("SPP");
        department.setAddress("AR");
        department.setId(45L);

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        Department result = departmentServiceIImplementation.getDepartmentsbyID(departmentId);

        assertNotNull(result);
        assertEquals(department.getId(), result.getId());

    }

    @Test
    void deleteRecordsTest() {
        long departmentId = 45L;

        doNothing().when(departmentRepository).deleteById(departmentId);

        departmentServiceIImplementation.deleteRecords(departmentId);

        assertNotNull(departmentId);
        verify(departmentRepository, times(1)).deleteById(departmentId);

    }

    @Test
    void updateDepartmentTest() {
        long departmentId = 45L;

        Department department = new Department();
        department.setDepartmentName("IT");
        department.setCompany("SPP");
        department.setAddress("AR");
        department.setId(45L);

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));
        when(departmentRepository.save(any(Department.class))).thenReturn(department);

        Department result = departmentServiceIImplementation.UpdateDepartment(departmentId, department);

        assertNotNull(result);
        assertEquals(department.getDepartmentName(), result.getDepartmentName());
    }


    @Test
    void getDataByNameTest() {
        String departmentName = "IT";

        Department department = new Department();
        department.setDepartmentName("IT");
        department.setCompany("SPP");
        department.setAddress("AR");
        department.setId(45L);

        when(departmentRepository.findByDepartmentNameIgnoreCase(departmentName)).thenReturn(department);

        Department result = departmentServiceIImplementation.getDataByName(departmentName);

        assertNotNull(result);

    }

}