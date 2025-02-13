package com.info.mapper;

import com.info.dto.Employee;
import com.info.entity.EmpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

   Employee mapEntityToDto(EmpEntity empEntity);

   List<Employee> mapEntitiesToDtos(List<EmpEntity> empEntities);

}
