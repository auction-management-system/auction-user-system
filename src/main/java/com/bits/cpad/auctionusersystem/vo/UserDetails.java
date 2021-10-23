package com.bits.cpad.auctionusersystem.vo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@ToString
@Data
@Builder
public class UserDetails {

    private Long Id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Long bankAccountNumber;

}
