package com.cydeo.entity;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataGenerator {

    List<User> users = new ArrayList<>();

    public static List<Role> roles(){
        return Arrays.asList(

        );
    }

    public List<User> saveUser(User user){
        users.add(user);
        return users;

    }

    public List<User> readAllUsers(){
        return users;
    }
}
