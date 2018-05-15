package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //在此处完成Employee API
    //    GET       /employees/page/1/pageSize/5  #分页查询，page等于1，pageSize等于5
//    GET       /employees/male   #筛选出所有男性Employee
//    POST      /employees    #增加一个employee
//    PUT       /employees/1  #更新某个employee
//    DELETE    /employees/1  #删除某个employee
    @Autowired
    EmployeeRepository employeeRepository;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee saveEmployee(@RequestBody Employee employee){return employeeRepository.save(employee);}

    //    GET       /employees    #获取employee列表
    @GetMapping
    List<Employee> getEmployeesList(){return employeeRepository.findAll();}
    //    GET       /employees/1  #获取某个具体employee
//    @GetMapping(value = "{id}")
//    Employee getEmployee(@PathVariable long id) throws NotFoundException{
//        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
//    }


}
