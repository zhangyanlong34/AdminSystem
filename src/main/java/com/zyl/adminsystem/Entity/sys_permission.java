package com.zyl.adminsystem.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="sys_permission")
public class sys_permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column
    private String name;

    @Column
    private String controller;

    @Column
    private Integer value;

    @ManyToMany(mappedBy = "permissions")
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

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<sys_role> getRoles() {
        return roles;
    }

    public void setRoles(List<sys_role> roles) {
        this.roles = roles;
    }
}
