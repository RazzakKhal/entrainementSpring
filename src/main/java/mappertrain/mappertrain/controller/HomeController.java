package mappertrain.mappertrain.controller;

import mappertrain.mappertrain.entity.MyUser;
import mappertrain.mappertrain.entity.School;
import mappertrain.mappertrain.service.UserService;
import mappertrain.mappertrain.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    SchoolService schoolService;

    @GetMapping("/findAll")
   List<MyUser> returnUser(){
        return userService.findAllUsers();
    }

    @PostMapping("/createUser")
    MyUser createUser(@RequestBody MyUser user){
       return userService.createUser(user);
    }

    @PostMapping("/createSchool")
    School createSchool(@RequestBody School school){
        return schoolService.createSchool(school);
    }

    @GetMapping("/findSchool/{id}")
    School findSchool(@PathVariable Long id) throws Exception {
        return schoolService.findSchool(id);
    }
}
