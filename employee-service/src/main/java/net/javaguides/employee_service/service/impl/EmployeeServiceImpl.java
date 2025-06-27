package net.javaguides.employee_service.service.impl;

import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.exception.ResourceNotFoundException;
import net.javaguides.employee_service.mapper.AutoEmployeeMapper;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        //return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        //EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        return employeeDto;
    }
}
