package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.entity.User;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(), object);
    }

    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO findById(String username) {
        return super.findById(username);
    }

    @Override
    public void deleteById(String username) {
        super.deleteById(username);
    }

    @Override
    public UserDTO update(UserDTO object) {
        return super.update(object.getUserName(), object );
    }
}
