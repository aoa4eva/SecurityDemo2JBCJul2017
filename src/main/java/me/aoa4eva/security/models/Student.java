package me.aoa4eva.security.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @Email
    private String email;

    private String fname;

    private String lname;

    private String username;

    private String password;

    @ManyToMany(fetch=FetchType.EAGER)
    private Collection<RoleClass> roles;

    public Student() {
        this.roles=new HashSet <RoleClass>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addRole(RoleClass r)
    {
        this.roles.add(r);
    }

    public Collection<RoleClass> getRoles() {
        return roles;
    }

    public void setRoles(Collection<RoleClass> roles) {
        this.roles = roles;
    }
}
