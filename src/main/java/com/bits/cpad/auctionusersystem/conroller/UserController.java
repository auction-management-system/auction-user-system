package com.bits.cpad.auctionusersystem.conroller;

import com.bits.cpad.auctionusersystem.service.UserService;
import com.bits.cpad.auctionusersystem.vo.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public UserDetails getUserById(@PathVariable("id") Long userId) {
        if (userId != 0) {
            return userService.getUserById(userId);
        } else throw new IllegalArgumentException("UserId in path is zero");
    }

    @GetMapping("/user")
    public UserDetails getUserByUserName(@RequestParam("username") String userName) {
        if (!userName.isEmpty()) {
            return userService.getUserByUserName(userName);
        } else throw new IllegalArgumentException("UserName in path is null/empty");
    }

    @GetMapping("/users/getAll")
    public List<UserDetails> getAllUsers() {
        List<UserDetails> userDetails = userService.getAllUsers();
        if (userDetails.isEmpty()) {
            return new ArrayList<>();
        }
        return userDetails;
    }

    @PostMapping
    public Long addUserDetails(@RequestBody @NotNull UserDetails userDetails) {
        return userService.addUser(userDetails);
    }

    @PutMapping
    public UserDetails updateUserDetails(@RequestBody @NotNull UserDetails userDetails) {
        return userService.updateUser(userDetails);
    }

    @DeleteMapping("/user/{userId}")
    public boolean deleteUserDetail(@PathVariable("userId") @NotNull Long userId){
        if (userId != 0) {
            return userService.deleteUser(userId);
        } else throw new IllegalArgumentException("UserId in path is zero");
    }
}
