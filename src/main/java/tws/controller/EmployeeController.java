package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody Employee employee) {
    	employeeMapper.insert(employee);
    }
    
    @GetMapping(path = "/{id}")
    public Employee selectSinglEmployee(@PathVariable int id) {
    	return employeeMapper.selectSingleEmployee(id);
    }
    
    @PutMapping(path = "/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
    	employeeMapper.updateEmployee(employee);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable int id) {
    	employeeMapper.deleteEmployee(id);
    }

}
