package com.bits.cpad.auctionusersystem.service;

import com.bits.cpad.auctionusersystem.vo.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails getUserById(Long Id);

    UserDetails getUserByUserName(String userName);

    List<UserDetails> getAllUsers();

    Long addUser(UserDetails userDetails);

    UserDetails updateUser(UserDetails userDetails);

    boolean deleteUser(Long userId);
}
