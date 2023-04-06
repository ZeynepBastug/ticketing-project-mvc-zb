package com.cydeo.dto;

import com.cydeo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDTO {

    private String projectName;
    private String ProjectCode;
    private UserDTO assignedManager;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private String projectDetail;
    private Status projectStatus;

}
