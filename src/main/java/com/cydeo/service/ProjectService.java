package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDTO, String> {

    void updateStatus(ProjectDTO project);

    List<ProjectDTO> getCountedListOffProjectDTO(UserDTO user);
}
