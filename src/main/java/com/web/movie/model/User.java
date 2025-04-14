package com.web.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "tbl_user")
@AllArgsConstructor
@NoArgsConstructor
public class User extends AbstractEntity<Long>{

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String address;
    private String avatarUrl;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
}
