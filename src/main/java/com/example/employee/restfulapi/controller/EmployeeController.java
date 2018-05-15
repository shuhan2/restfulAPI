package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.employee.restfulapi.NotFoundEx;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    //在此处完成Employee API
    @Autowired
    EmployeeRepository employeeRepository;
    //    GET       /employees    #获取employee列表
    @GetMapping
    List<Employee> getEmployeesList(){return employeeRepository.findAll();}
    //    GET       /employees/1  #获取某个具体employee
    @GetMapping(value = "{id}")
    Employee getEmployeeById(@PathVariable long id) throws NotFoundException{
        Employee employee =  employeeRepository.findOne(id);
        if(employee!= null) {
            return employeeRepository.findOne(id);
        }
        else {
            throw new NotFoundEx(id,"employee");
        }
    }
    //    GET       /employees/page/1/pageSize/5  #分页查询，page等于1，pageSize等于5
    @GetMapping(value = "page/{page}/pageSize/{pageSize}")
    List<Employee> getEmployeesByPageAndPageSize(@PathVariable int page,@PathVariable int pageSize)throws NotFoundException {
        Page<Employee> employees = employeeRepository.findAll(new PageRequest(page, pageSize));
       // return employees.getContent();
        return employees.getContent();
    }
    //    GET       /employees/male   #筛选出所有男性Employee
    @GetMapping(value = "male")
    List<Employee> findAllMaleEmployees(){
        return employeeRepository.findByGenderIsIn("male");
    }
    //   POST      /employees    #增加一个employee
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Employee saveEmployee(@RequestBody Employee employee){return employeeRepository.save(employee);}

    //   PUT       /employees/1  #更新某个employeegit
    @PutMapping("{id}")
    Employee putEmployee(@PathVariable long id, @RequestBody Employee employee)  throws NotFoundException{
        Employee employee2 =employeeRepository.findById(id);
        if(employee2==null){
            throw   new NotFoundEx(id,"employee");
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    //    DELETE    /employees/1  #删除某个employee
    @DeleteMapping("{id}")
    String deleteEmployee(@PathVariable long id) throws NotFoundException{
        Employee employee =employeeRepository.findById(id);
        if (employee==null){
            throw new NotFoundEx(id,"employee");
        }
        else {
            employeeRepository.delete(employeeRepository.findById(id));
            return "delete success";
        }

    }

}
