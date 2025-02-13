package com.info.service;

import com.info.dto.Employee;
import com.info.entity.EmpEntity;
import com.info.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployeeDetails(){

        Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(EmpEntity.builder().build());
        String result =  employeeService.saveEmployeeDetails(Employee.builder()
                .id(123)
                .name("raj")
                .salary(2300.0)
                .build());
        Assert.assertEquals(result,"Successfully save employee details.");
    }
}
