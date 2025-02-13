package com.info.resource;

import com.info.dto.Employee;
import com.info.exception.ApplicationError;
import com.info.exception.ApplicationException;
import com.info.exception.ErrorCode;
import com.info.service.EmployeeService;
import com.info.util.Constant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.info.util.Constant.API_EMP;

@Api("Set of endpoints for employee operations")
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = API_EMP, produces = Constant.APP_V1_JSON)
@Slf4j
public class EmployeeResource {

    @Autowired
    EmployeeService service;

    @ApiOperation(value = "Resource method to add Employee", response = String.class)
    @PostMapping("/save")
    public String saveEmployeeDetails(@RequestBody Employee employee) {

        if (employee.getId() <= 0){
            ApplicationError error = ApplicationError.builder()
                    .code(ErrorCode.ERR_400_00.getCode())
                    .message(ErrorCode.ERR_400_00.getMessage())
                    .detail(ErrorCode.ERR_400_00.getMessage())
                    .build();

            throw new ApplicationException(HttpStatus.BAD_REQUEST, "validation failed",error);
        }
        return service.saveEmployeeDetails(employee);
    }

    @ApiOperation(value = "Resource method to get all employees",response = Employee.class)
    @GetMapping("/allEmps")
    public List<Employee> getAllEmps(){
    log.info("STart: get all employees");
        return service.getAllEmps();
    }
}
