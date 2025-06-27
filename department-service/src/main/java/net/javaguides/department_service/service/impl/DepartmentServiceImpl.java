package net.javaguides.department_service.service.impl;

import net.javaguides.department_service.dto.DepartmentDto;
import net.javaguides.department_service.entity.Department;
import net.javaguides.department_service.exception.ResourceNotFoundException;
import net.javaguides.department_service.mapper.AutoDepartmentMapper;
import net.javaguides.department_service.repository.DepartmentRepository;
import net.javaguides.department_service.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        //Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department department = modelMapper.map(departmentDto, Department.class);

        Department savedDepartment = departmentRepository.save(department);
        //return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
        return modelMapper.map(savedDepartment, DepartmentDto.class);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        if(Objects.isNull(department)){
            throw new ResourceNotFoundException("Department", "departmentCode", departmentCode);
        }

        //return AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);
        return modelMapper.map(department, DepartmentDto.class);
    }

}
