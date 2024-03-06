package com.example.springDemo.controller;

import com.example.springDemo.dto.UserDTO;
import com.example.springDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDto){   //convert json data object to java object
        return userService.saveUser(userDto);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public Boolean deleteUser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }

    @GetMapping("/getUserByID/{userID}")
    public UserDTO getUserByID(@PathVariable String userID){
        return userService.getUserByID(userID);
    }

    @GetMapping("/getUserByIDAndAddress/{userID}/{address}")
    public UserDTO getUserByIDAndAddress(@PathVariable String userID, @PathVariable String address){return userService.getUserByIDAndAddress(userID, address); }
}
