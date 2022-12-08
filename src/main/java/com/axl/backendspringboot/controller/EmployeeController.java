package com.axl.backendspringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import com.axl.backendspringboot.exception.ResourceNotFoundException;
import com.axl.backendspringboot.model.Employee;
import com.axl.backendspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tiene clases con el objetivo principal de conectar el backend
 * con las solicitudes que se hagan desde afuera de la aplicacion
 * (sistemas web, unirest, api restful, entre otros)
 * */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
    /*Codigo para solicitar la consulta completa de todos los datos registrado
    * /empleados*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		//retorna todo los datos encontrados con el findAll
		return employeeRepository.findAll();
	}
    /*Consulta por id utilizando GET y retorna todo el objeto*/
	@GetMapping("/employees/{id}")
	public ResponseEntity < Employee > getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}
     //guardar con el metodo POST se guarda agregadno datos al body
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}


	//Se guardan los cambios actualizados buscando por id y cambiando el body para que se vea efectuado la configuracion.
	@PutMapping("/employees/{id}")
	public ResponseEntity <Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
													  @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	/*Borrar el empleado por id*/
	@DeleteMapping("/employees/{id}")
	public Map < String, Boolean > deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map <String,Boolean> response = new HashMap < > ();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
