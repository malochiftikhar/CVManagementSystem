package com.CVManagementSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    UserRepository myRepository;

    @Autowired
    CVRepository cvRepository;

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return myRepository.save(user);
    }

    @PostMapping("/login")
    public String checkLogin(@RequestBody User user) {
        List<User> users = myRepository.findByEmail(user.getEmail());
        for (User u : users) {
            if (u.getPassword().equals(user.getPassword())) {
                User userAccount = new User(u.getId(), u.getfName(), u.getlName(), u.getUserName(), u.getUserType(),u.getEmail(), u.getPassword());
                return userAccount.getfName();
            }
        }
        return "Username or Password incorrect";
    }

    @GetMapping("getuser/{id}")
    public User getUserByID(@PathVariable(value = "id") Long userId) {
        return myRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return myRepository.findAll();
    }

    @GetMapping("/user/{id}/cv")
    public Page<CV> getAllCVsByUserID(@PathVariable(value = "id") Long id, Pageable pageable) {
        return cvRepository.findByUserId(id, pageable);
    }
}
