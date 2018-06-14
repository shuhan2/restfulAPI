package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.NotFoundEx;
import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

    //在此处完成Company API
    @Autowired
    CompanyRepository companyRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    // GET       /companies    #获取company列表
    @GetMapping
    List<Company> findAllCompany(){
      return  companyRepository.findAll();
    }

    // GET       /companies/1  #获取某个具体company
    @GetMapping(value = "{id}")
    Company findComanyById(@PathVariable Long id) throws NotFoundException {
        Company company = companyRepository.findOne(id);
        if (company == null){
            throw new NotFoundEx(id,"company");
        }
        else {
            return companyRepository.findOne(id);
        }
    }
    // GET       /companies/1/employees  #获取某个具体company下所有employee列表
    @GetMapping(value = "{id}/employees")
    List<Employee> findConmaonyEmployees(@PathVariable Long id) throws NotFoundException{
        Company company = companyRepository.findOne(id);
        if (company == null){
            throw new NotFoundEx(id,"company");
        }
        else {
            return employeeRepository.findByCompanyId(id);
        }
    }
    // GET       /companies/page/1/pageSize/5  #分页查询，page等于1，pageSize等于5
    @GetMapping(value = "page/{page}/pageSize/{pageSize}")
    List<Company> getCompanysByPageAndPageSize(@PathVariable int page,@PathVariable int pageSize)throws NotFoundException {
        Page<Company> compays = companyRepository.findAll(new PageRequest(page, pageSize));
        // return employees.getContent();
        return compays.getContent();
    }
    //POST      /companies    #增加一个company
    @PostMapping
    Company createCompany(@RequestBody Company company){
        return companyRepository.save(company);
    }
    //PUT       /companies/1  #更新某个company
    @PutMapping(value="{id}")
    String  updateCompany(@RequestBody Company company,@PathVariable Long id){
        Company company1 = companyRepository.findOne(id);
        if(company1!=null) {
             companyRepository.save(company);
            return  "update success";
        }
        throw new NotFoundEx(id,"company");
    }
    //DELETE    /companies/1  #删除某个company以及名下所有employees
    @DeleteMapping("{id}")
    String deleteCompany(@PathVariable long id){
        Company company =companyRepository.findById(id);
        if (company==null){
            throw new NotFoundEx(id,"company");
        }
        else {
            companyRepository.delete(companyRepository.findById(id));
            return "delete success";
        }
    }

}
