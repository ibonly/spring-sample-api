package com.ibonly.test.demo.Controller;

import com.ibonly.test.demo.Model.UserModel;
import com.ibonly.test.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/test/api")
public class UserController {

    @Autowired

    private UserRepository UR;

    @PostMapping("/user")
    @ResponseBody
    public UserModel user(@RequestBody UserModel um) {
        UR.save(um);

        return um;
    }

    @GetMapping("/users")
    @ResponseBody
    public Iterable<UserModel> users() {
        return UR.findAll();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserModel getUser(@PathVariable Integer id) {
        Optional<UserModel> OPT = UR.findById(id);

        return OPT.get();
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public String deleteUser(@PathVariable Integer id) {
        UR.deleteById(id);

        return "Delete successful"
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public ResponseEntity<Object> edit(@RequestBody UserModel user, @PathVariable Integer id) {
        Optional<UserModel> OPT = UR.findById(id);
        if(!OPT.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        user.setId(id);
        UR.save(user);

        return ResponseEntity.noContent().build();
    }
}
