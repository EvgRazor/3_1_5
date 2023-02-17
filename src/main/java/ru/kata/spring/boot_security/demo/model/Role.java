package ru.kata.spring.boot_security.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "name")
    private String name;

    @Transient
    private Role role;

    public Role () {

    }

    public Role(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name + ", ";
    }

    @Override
    public String getAuthority() {
        return getRole().getName();
    }

    public Role getRole() {
        return role;
    }



}
