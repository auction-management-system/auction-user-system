package com.bits.cpad.auctionusersystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(schema = "auction",name = "user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Long Id;
    @Size(min=3, max=10,
            message="Username must be between 3 and 10 characters.")
    @Pattern(regexp="^[a-zA-Z0-9]+$",
            message="Username must be alphanumeric with no space.")
    @Column(name = "username")
    private String username;
    @Size(min=6, max=20,
            message="The password must be at least 6 characters.")
    @Column(name = "password")
    private String password;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",
            message="Invalid email address.")
    @Column(name = "email")
    private String email;
    @Column(name = "bankAccount")
    private Long bankAccountNumber;

}
