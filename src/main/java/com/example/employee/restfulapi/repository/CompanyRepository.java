package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Company;
import java.util.List;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    //以下所有的*都代表变量

//    //1.查询名字是*的第一个company
//    Company findFirstByName(String name);
//
//    //4.实现对Company的分页查询，每页两个数据,每页两条数据，一共三页数。
//    //注意：PageRequest的构造方法已经弃用了代替的是PageRequest.of,并且最后一个参数代表按照table中的哪一个字段排序
//    Page<Company> findAll(Pageable pageable);
//
//    //6.将*的名字改成*,输出这次修改影响的行数
//    @Modifying
//    @Query("update Company company set company.name =?1  where company.name =?2 ")
//    int modifyByName(String outputName,String inputName);
//    //7.删除姓名是*的company
//    @Modifying
//    @Query("delete from Company company   where company.name =?1")
//    void deleteByName(String name);
//    List<Company> findByGenderIsIn(String gender);
    Company findById(long id);
    List<Employee> findById (Long companyId);

}
