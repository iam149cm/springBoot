package io.iam149cm.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "Department Dto Model"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            description = "Department Name",
            example = "Computer Science"
    )
    private String departmentName;
    @Schema(
            description = "Department Description",
            example = "Computer Science Department"
    )
    private String departmentDescription;
    @Schema(
            description = "Department Code",
            example = "CS"
    )
    private String departmentCode;
}
