package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends CrudService<UserDTO, String>{

    List<UserDTO> findManagers();


}
