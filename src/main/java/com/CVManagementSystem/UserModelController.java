package com.CVManagementSystem;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserModelController {

    @Autowired
    UserRepo myRepository;

    @Autowired
    CVRepository cvRepository;

    @PostMapping("/addUser")
    public UserModel createUser(@Valid @RequestBody UserModel user) {
        return myRepository.save(user);
    }

    @GetMapping("getuser/{id}")
    public UserModel getUserByID(@PathVariable(value = "id") Long userId) {
        return myRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", userId));
    }

    @GetMapping("/listUsers")
    public List<UserModel> getAllUsers() {
        return myRepository.findAll();
    }

    @GetMapping("/user/{id}/cv")
    public Page<UserCV> getAllCVsByUserID(@PathVariable(value = "id") Long id, Pageable pageable) {
        return cvRepository.findByUserId(id, pageable);
    }

}
