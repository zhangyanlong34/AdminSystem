package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public sys_user findUserByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public List<sys_user> findAll() {
        List<sys_user> users = userRepository.findAll();
        return users;
    }
}
