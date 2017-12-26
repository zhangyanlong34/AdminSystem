package com.zyl.adminsystem.Entity;

import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="sys_role")
public class sys_role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    @Column
    private String name ;

    @ManyToMany(mappedBy = "roles")
    private List<sys_user> users;

    @ManyToMany
    @JoinTable(name="sys_role_permission",
            joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="permission_id",referencedColumnName = "id"))
    private List<sys_permission> permissions;

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

    public List<sys_user> getUsers() {
        return users;
    }

    public void setUsers(List<sys_user> users) {
        this.users = users;
    }

    public List<sys_permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<sys_permission> permissions) {
        this.permissions = permissions;
    }
}
