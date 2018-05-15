package com.example.employee.restfulapi;

import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.flywaydb.core.Flyway;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;

//import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
//import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;



public class RestfulApiApplicationTests {
//  @Autowired
//  private EmployeeRepository employeeRepository;
//  @Before
//  public void setUp() throws Exception {
//    //本地启动mysql，创建employee_db数据库
//    Flyway flyway = new Flyway();
//    flyway.setDataSource("jdbc:mysql://localhost:3306/employee_db","root","123456");
//    flyway.clean();
//    flyway.migrate();
//  }
//
//  @Test
//  public void should_return_employee_when_input_employee_name() throws Exception {
//    //1.查询名字是小红的employee
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000, temp);
//    //      String actualName = null;
//    String actualName = employeeRepository.findFirstByName(expectedEmployee.getName()).getName();
//    assertThat(actualName).isEqualTo(expectedEmployee.getName());
//  }

//  @Test
//  public void should_return_employee_given_character_in_name_and_salary_large_than() throws Exception {
//    //2.找出Employee表中第一个姓名包含`n`字符的雇员所有个人信息
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000,temp);
//    String actualName = employeeRepository.findDistinctFirstByNameContains(expectedEmployee.getName()).getName();
//    assertThat(actualName).isEqualTo(expectedEmployee.getName());
//  }
//
//  @Test
//  public void should_return_employee_name_when_employee_salary_is_max_and_given_company_id_() throws Exception {
//    //3.找出一个薪资最高且公司ID是1的雇员以及该雇员的name
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000,(long)1);
//    String actualName = employeeRepository.findTop1BySalaryAndCompanyId(expectedEmployee.getSalary(),expectedEmployee.getCompanyId()).getName();
//    assertThat(actualName).isEqualTo(expectedEmployee.getName());
//  }
//
//  @Test
//  public void should_return_employee_list_when_input_page_request() throws Exception {
//    //4.实现对Employee的分页查询，每页两条数据，一共三页数。
//    //注意：PageRequest的构造方法已经弃用了代替的是PageRequest.of,并且最后一个参数代表按照table中的哪一个字段排序
////    Page<Employee> EmployeePage = employeeRepository.findAll(new PageRequest(1,2,null));
//    Page<Employee> EmployeePage = null;
//    assertThat(EmployeePage.getTotalPages()).isEqualTo(3);
////        assertThat(EmployeePage.getSize()).isEqualTo(2);
////        assertThat(EmployeePage.getPageable()).isEqualTo(PageRequest.of(1,2));
//  }
//
//  @Test
//  public void should_return_company_name_when_input_employee_name() throws Exception {
//    //5.查找xiaohong的所在的公司的公司名称
//    String expectedCompanyName = "alibaba";
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000, temp);
//    String actualCompanyName = employeeRepository.findByName(expectedEmployee.getName()).getCompany().getCompanyName();
//    assertThat(actualCompanyName).isEqualTo(expectedCompanyName);
//  }
//
//  @Test
//  public void should_return_influence_lines_when_update_employee_name() throws Exception {
//    //6.将xiaohong的名字改成xiaobai,输出这次修改影响的行数
//    Integer expectedLine = 1;
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000, temp);
//    Integer actualLine = employeeRepository.modifyByName("xiaohai","xiaohong");
//    assertThat(actualLine).isEqualTo(expectedLine);
//  }
//
//  @Test
//  public void should_deleted_employee_when_given_employee_name() throws Exception {
//    //7.删除姓名是xiaohong的employee
//    Long temp = (long)1;
//    Employee expectedEmployee = new Employee("xiaohong",19,"female",7000, temp);
//    employeeRepository.deleteByName(expectedEmployee.getName());
//    Employee actualEmployee = employeeRepository.findFirstByName(expectedEmployee.getName());
//    assertThat(actualEmployee).isNull();
//  }


}
