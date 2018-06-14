package com.example.employee.restfulapi.repository;

import com.example.employee.restfulapi.entity.Employee;

import java.util.EnumMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>,CrudRepository<Employee,Long> {
  //以下所有的*都代表变量

  //1.查询名字是*的第一个employee
  Employee findFirstByName(String name);
  //2.找出Employee表中第一个姓名包含`n`字符的雇员所有个人信息
  Employee findDistinctFirstByNameContains(String name);
  //3.找出一个薪资最高且公司ID是*的雇员以及该雇员的姓名
  Employee findTop1BySalaryAndCompanyId(int salary,long companyId);
  //4.实现对Employee的分页查询，每页两个数据,每页两条数据，一共三页数。
  //注意：PageRequest的构造方法已经弃用了代替的是PageRequest.of,并且最后一个参数代表按照table中的哪一个字段排序
  @Override
  Page<Employee> findAll(Pageable pageable);
  //5.查找**的所在的公司的公司名称
  Employee findByName(String name);
  //6.将*的名字改成*,输出这次修改影响的行数
  @Modifying
  @Query("update Employee employee set employee.name =?1  where employee.name =?2 ")
  int modifyByName(String outputName,String inputName);
  //7.删除姓名是*的employee
  @Modifying
  @Query("delete from Employee employee   where employee.name =?1")
  void deleteByName(String name);
  List<Employee> findByGenderIsIn(String gender);
  Employee findById(long id);
  List<Employee> findAll();
  List<Employee> findByCompanyId(Long companyId);


}
