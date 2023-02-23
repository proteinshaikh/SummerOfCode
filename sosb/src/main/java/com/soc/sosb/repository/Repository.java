package com.soc.sosb.repository;

import com.soc.sosb.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Employee, Long> {
    List<Employee> findByName(String name);

}
