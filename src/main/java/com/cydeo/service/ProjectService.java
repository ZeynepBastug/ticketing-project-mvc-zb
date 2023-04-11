package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.service.CrudService;
import org.springframework.stereotype.Service;


@Service
public interface ProjectService extends CrudService<ProjectDTO, String> {

    void updateStatus(ProjectDTO project);
}
