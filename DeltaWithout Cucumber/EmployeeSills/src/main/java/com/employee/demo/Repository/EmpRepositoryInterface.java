package com.employee.demo.Repository;

import java.util.List;

import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;

public interface EmpRepositoryInterface {

    List<Employee> getAllEmployees();
    //List<Skill> getAllSkills();
    Employee addEmployee(Employee employee);
    Employee updateEmployeeDetails(Employee employee);
    void deleteEmployeeDetails(Long empId);
    void addSkillName(Skill skill);
    Employee getEmployeeById(Long empId);
    //Skill findSkillById(Long skillId);
    //Object getEmployeeAndSkillById(Long empId, Long skillId);
    
    
    public int[] batchInsert(List<Employee> employees);
   // public int[] batchSkillInsert(List<Skill> skills);
    //public int[] batchInsert(List<Employee> employees, List<Skill> skills);
}
