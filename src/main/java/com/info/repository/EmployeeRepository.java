package com.info.repository;

import com.info.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmpEntity, Integer> {

    @Query("select e from EmpEntity e  where e.id = :id and e.salary = :salary")
    public List<EmpEntity> getEmpsbyIdAndSalary(@Param("id") Integer id,
                                                @Param("salary") Double salary);
}
