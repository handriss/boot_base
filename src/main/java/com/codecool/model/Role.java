package com.codecool.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="role")
@Slf4j
public class Role {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String role;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;

    private Role(){}

    public Role(String role){
        this.role = role;
    }
}
