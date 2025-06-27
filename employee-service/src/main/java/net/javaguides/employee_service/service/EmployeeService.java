package net.javaguides.employee_service.service;

import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.repository.EmployeeRepository;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
}
