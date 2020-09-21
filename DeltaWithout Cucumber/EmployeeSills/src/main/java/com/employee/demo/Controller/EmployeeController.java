package com.employee.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.Services.EmpServiceInterface;
import com.employee.demo.Services.SkillServiceInterface;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;
import com.employee.demo.exception.ResourceNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private EmpServiceInterface empService;
	
	@Autowired(required=true)
	private SkillServiceInterface skillService;
	
	// *********** EMPLOYEE CONTROLLER  ****************
	
	@RequestMapping(value="/emp/getemployees", method=RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> emplist=empService.getAllEmployees();
		
		if(emplist==null) {
			throw new ResourceNotFoundException("No Employee Details found");
		}
		return new ResponseEntity<List<Employee>>(emplist,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employeeById/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId){
		
		Employee emp=empService.getEmployeeById(empId);
		if(emp!=null) {
			
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		}
		else 
        {
            throw new ResourceNotFoundException("Employee with id "+empId+" is not found");
        }
	}
	
	
	@RequestMapping(value="/employee/deleteById/{empId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable(value= "empId") Long empId) {
		
		empService.deleteEmployeeDetails(empId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	
	@PutMapping("/emp/updateEmployee")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee){
		
		if(employee!=null) {
			
			empService.updateEmployeeDetails(employee);
		}
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	// batch Insert - inserting multiple records at a time
	@RequestMapping(value="/emp/addbatchemployee", method=RequestMethod.POST)
	public int[] batchInsert(@RequestBody List<Employee> employees) {
			
		return empService.batchInsert(employees);
	}
	
	
	// INSERTING BOTH EMPLOYEE AND SKILL TOGETHER
	
	@RequestMapping(value="/emp/addemployee", method=RequestMethod.POST)	
	public void addEmployee(@RequestBody Employee employee) {
		
			empService.addEmployee(employee);
			// return new ResponseEntity<Void>(emp, HttpStatus.CREATED)
			
	}
		
	// ********* SKILL CONTROLLER ************
	
	@RequestMapping(value="/skills/getskills", method=RequestMethod.GET)
	public ResponseEntity<List<Skill>> getAllSkills(){
		
		List<Skill> skillist=skillService.getAllSkills();
		
		if(skillist==null) {
			throw new ResourceNotFoundException("No Skill Details found");
		}
		
		return new ResponseEntity<List<Skill>>(skillist,HttpStatus.OK);
	}
	

	@RequestMapping(value="/emp/addbatchskills", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	//@PostMapping("/skills/addbatchskills")
	public int[] batchSkillInsert(@RequestBody List<Skill> skills) {
		
		return skillService.batchSkillInsert(skills);
	}
	
	
	// Get Skill details by SkillId
	
	@GetMapping("skills/skillsById/{skillId}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Long skillId){
		
		Skill skills= skillService.findSkillById(skillId);
		if(skills!=null) {
			
			return new ResponseEntity<Skill>(skills, HttpStatus.OK);
		}
		else 
        {
            throw new ResourceNotFoundException("Skill with id "+skillId+" is not found");
        }
	}
	
	@PutMapping("/skill/updateskills")
	public ResponseEntity<Skill> updateSkillDetails(@RequestBody Skill skill){
		
		if(skill!=null) {
			
			skillService.updateSkillDetails(skill);
		}
		
		return new ResponseEntity<Skill>(skill, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/skill/deleteById/{skillId}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSkillDetails(@PathVariable(value= "skillId") Long skillId) {
		
		skillService.deleteSkillDetails(skillId);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	//GET SKILL DETAILS BY EMPLOYEE ID OR EMPLOYEE NAME //
}
