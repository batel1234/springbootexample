package com.javatpoint.controller;

import com.javatpoint.model.User;
import com.javatpoint.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
//import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUser(){ // מציג את כול משתמשים
        return userRepository.findAll();
    }

    @GetMapping("/users/{name}") // כול המשתמשים לפי שם
    public List<User> getAllUserByName(@PathVariable String name){
        return userRepository.findUsersByNameContains(name);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable Long id){
//        Optional<User> u= userRepository.findById(id); // אם זה קיים תחזיר אם זה לא קיים משתמש לא נימצא
//        return u.map(user1 -> ResponseEntity.ok().body(user1))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
    @PostMapping("/signUp")
    public ResponseEntity<User> creatUser(@RequestBody User u)  throws URISyntaxException { //הוספה של משתמש חדש
        User newUser=userRepository.save(u);
        return ResponseEntity.created(new URI("/api/user/"+newUser.getId())).body(newUser);
    }
    @PutMapping("/{id}")
    // עדכון של משתמש
    public ResponseEntity<?> updateUser(@PathVariable Long id ,@RequestBody User a)throws URISyntaxException{
        if(id!=a.getId())
            return ResponseEntity.badRequest().build();
        User updateUser= userRepository.save(a);
        return ResponseEntity.created(new URI("/api/user/"+updateUser.getId())).body(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){// מחיקת משתמש
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}
