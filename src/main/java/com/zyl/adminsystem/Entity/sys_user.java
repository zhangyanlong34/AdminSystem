package com.zyl.adminsystem.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="sys_user")
public class sys_user {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String password;

    @ManyToMany
    @JoinTable(name="sys_user_role",
               joinColumns = @JoinColumn(name="user_id",referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private List<sys_role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<sys_role> getRoles() {
        return roles;
    }

    public void setRoles(List<sys_role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
