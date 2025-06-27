package net.javaguides.employee_service.service.impl;

import net.javaguides.employee_service.dto.APIResponseDto;
import net.javaguides.employee_service.dto.DepartmentDto;
import net.javaguides.employee_service.dto.EmployeeDto;
import net.javaguides.employee_service.entity.Employee;
import net.javaguides.employee_service.exception.ResourceNotFoundException;
import net.javaguides.employee_service.mapper.AutoEmployeeMapper;
import net.javaguides.employee_service.repository.EmployeeRepository;
import net.javaguides.employee_service.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    //private final RestTemplate restTemplate;
    private final WebClient webClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper, WebClient webClient) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.webClient = webClient;
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        //Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);

        //return AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

//    Microservice using RestTemplate
//    @Override
//    public APIResponseDto getEmployeeById(Long id) {
//        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
//        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
//        //EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);
//
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();
//
//        APIResponseDto apiResponseDto = new APIResponseDto();
//        apiResponseDto.setEmployeeDto(employeeDto);
//        apiResponseDto.setDepartmentDto(departmentDto);
//        return apiResponseDto;
//    }

    //    Microservice using WebClient
    @Override
    public APIResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        //EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        DepartmentDto departmentDto = webClient.get()
                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        return apiResponseDto;
    }
}
