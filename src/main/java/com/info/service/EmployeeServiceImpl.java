package com.info.service;

import com.info.dto.Employee;
import com.info.entity.EmpEntity;
import com.info.mapper.EmployeeMapper;
import com.info.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public String saveEmployeeDetails(Employee employee) {

        EmpEntity empEntity = EmpEntity.builder()
                .id(employee.getId())
                .name(employee.getName())
                .salary(employee.getSalary())
                .build();

       EmpEntity e =  employeeRepository.save(empEntity);

      return e != null ? "Successfully save employee details." : "try again";
    }

    @Override
    public List<Employee> getAllEmps() {
        List<EmpEntity> empEntities = employeeRepository.findAll();
        log.info("EmployeeServiceImpl :: no of records fetched from DB:{}", empEntities.size());

        /*List<Employee> employees = new ArrayList<>();
        for (EmpEntity empEntity : empEntities){
            Employee employee = Employee.builder()
                    .id(empEntity.getId())
                    .name(empEntity.getName())
                    .salary(empEntity.getSalary())
                    .build();
            employees.add(employee);
        }*/

        return employeeMapper.mapEntitiesToDtos(empEntities);
    }
}
