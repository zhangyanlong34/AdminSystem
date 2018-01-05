package com.zyl.adminsystem.Service;

import com.zyl.adminsystem.Entity.sys_role;
import com.zyl.adminsystem.Entity.sys_user;
import com.zyl.adminsystem.Entity.sys_user_role;
import com.zyl.adminsystem.Repository.UserRepository;
import com.zyl.adminsystem.Repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public sys_user findUserByName(String name) {
        return userRepository.findAllByName(name);
    }


    @Override
    public Page<sys_user> findAll(Pageable pageable) {
        Page<sys_user> users = userRepository.findAll(pageable);
        return users;
    }

    @Override
    @Transactional
    public void save(String username, String password, String roles) {
        sys_user sys_user = new sys_user();
        sys_user.setName(username);
        sys_user.setPassword(password);
        sys_user =  userRepository.save(sys_user);
        Integer user_id = sys_user.getId();
        if(!StringUtils.isEmpty(roles)){
            List<sys_user_role> userRoleList = new ArrayList<>();
            Arrays.asList(roles.split(",")).stream().forEach(role_id->{
                sys_user_role user_role = new sys_user_role();
                user_role.setRole_id(Integer.parseInt(role_id));
                user_role.setUser_id(user_id);
                userRoleList.add(user_role);
            });
            userRoleRepository.save(userRoleList);
        }
    }

}
