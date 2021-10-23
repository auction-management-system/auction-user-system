package com.bits.cpad.auctionusersystem.service.impl;

import com.bits.cpad.auctionusersystem.model.User;
import com.bits.cpad.auctionusersystem.repository.UserRepository;
import com.bits.cpad.auctionusersystem.service.UserService;
import com.bits.cpad.auctionusersystem.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails getUserById(Long Id) {
        Optional<User> user = userRepository.findById(Id);
        if(user.isPresent()){
            return constructResponse(user.get());
        }
        else throw new NoSuchElementException("No record found for UserId"+ Id);
    }

    @Override
    public UserDetails getUserByUserName(String userName) {
        Optional<User> user = userRepository.findByUsername(userName);
        if(user.isPresent()){
            return constructResponse(user.get());
        }
        else throw new NoSuchElementException("No record found for UserName"+ userName);
    }

    @Override
    public List<UserDetails> getAllUsers() {
        Iterable<User> user = userRepository.findAll();
        List<UserDetails> userDetails = new ArrayList<>();
         user.forEach(user1 -> {
            UserDetails userDetails1 = constructResponse(user1);
            userDetails.add(userDetails1);
        });
        return userDetails;
    }

    @Override
    public Long addUser(UserDetails userDetails) {
        User userRequest = constructRequest(userDetails,0L);
        User user = userRepository.save(userRequest);
        return user.getId();
    }

    @Override
    public UserDetails updateUser(UserDetails userDetails) {
        Optional<User> existingUser = userRepository.findById(userDetails.getId());
        if(existingUser.isPresent()) {
            User userRequest = constructRequest(userDetails,existingUser.get().getId());
            User user = userRepository.save(userRequest);
            return constructResponse(user);
        }
        else throw new NoSuchElementException("No record found for this User");
    }

    @Override
    public boolean deleteUser(Long userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if(existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return true;
        }
        else throw new NoSuchElementException("No record found for this User");
    }

    private UserDetails constructResponse(User user) {
        return UserDetails.builder()
                .Id(user.getId())
                .bankAccountNumber(user.getBankAccountNumber())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .username(user.getUsername())
                .build();
    }

    private User constructRequest(UserDetails userDetails, Long id) {
        User user = new User();
        if(id !=0L){
            user.setId(id);
        }
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEmail(userDetails.getEmail());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setBankAccountNumber(userDetails.getBankAccountNumber());
        return user;
    }

}
