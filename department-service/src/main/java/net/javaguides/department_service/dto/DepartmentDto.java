package net.javaguides.department_service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDto Modal Information"
)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department Name"
    )
    private String departmentName;
    @Schema(
            description = "Department Description"
    )
    private String departmentDescription;
    @Schema(
            description = "Department Code"
    )
    private String departmentCode;
}
