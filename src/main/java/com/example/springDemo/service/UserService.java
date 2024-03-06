package com.example.springDemo.service;

import com.example.springDemo.dto.UserDTO;
import com.example.springDemo.entity.User;
import com.example.springDemo.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    public UserDTO saveUser(UserDTO userDto){
        userRepo.save(modelMapper.map(userDto, User.class));
        return userDto;
    }

    public List<UserDTO> getAllUsers(){
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    public  UserDTO updateUser(UserDTO userDTO){
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public Boolean deleteUser(UserDTO userDTO){
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    public UserDTO getUserByID(String userID){
        User user = userRepo.getUserByID(userID);
        return modelMapper.map(user, UserDTO.class);
    }

    public UserDTO getUserByIDAndAddress(String userID, String address){
        User user = userRepo.getUserByIDAndAddress(userID, address);
        return modelMapper.map(user, UserDTO.class);
    }
}
