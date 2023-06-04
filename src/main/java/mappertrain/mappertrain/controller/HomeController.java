package mappertrain.mappertrain.controller;

import mappertrain.mappertrain.entity.MyUser;
import mappertrain.mappertrain.entity.Roles;
import mappertrain.mappertrain.entity.School;
import mappertrain.mappertrain.jdbc.UserJDBC;
import mappertrain.mappertrain.repository.MyUserRepository;
import mappertrain.mappertrain.repository.RolesRepository;
import mappertrain.mappertrain.service.RolesService;
import mappertrain.mappertrain.service.UserService;
import mappertrain.mappertrain.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    UserService userService;

    @Autowired
    SchoolService schoolService;

    @Autowired
    RolesService rolesService;

    @Autowired
    UserJDBC userJDBC;

    @GetMapping("/findAll")
    List<MyUser> returnUser() {
        return userService.findAllUsers();
    }

    @GetMapping("/findUser/{id}")
    MyUser returnOneUser(@PathVariable Long id) throws NullPointerException {
        if(userJDBC.findUserById(id).isPresent()){

            return userJDBC.findUserById(id).get();
        }else{
            throw new NullPointerException("Cet utilisateur n'existe pas");
        }
    }

    @PostMapping("/createUser")
    MyUser createUser(@RequestBody MyUser user) {
        return userService.createUser(user);
    }

    @PostMapping("/createSchool")
    School createSchool(@RequestBody School school) {
        return schoolService.createSchool(school);
    }

    @PostMapping("/createRole")
    Roles createRole(@RequestBody Roles role) {
        return rolesService.createRole(role);
    }

    @GetMapping("/findSchool/{id}")
    School findSchool(@PathVariable Long id) throws Exception {
        return schoolService.findSchool(id);
    }

    @DeleteMapping("/deleteSchool/{id}")
    String deleteSchool(@PathVariable Long id) {
        return schoolService.deleteSchool(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    String deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @DeleteMapping("/deleteRole/{id}")
    String deleteMyRole(@PathVariable Long id) {
        return rolesService.deleteMyRole(id);
    }

    @PutMapping("/addRole/{num}")
    String addRole(@RequestBody MyUser user, @PathVariable int num) {
        List<Roles> myRoles = user.getRoles();
        if (num == 1 && rolesRepository.findById(1L).isPresent()) {

            myRoles.add(rolesRepository.findById(1L).get());
            user.setRoles(myRoles);
            myUserRepository.save(user);
        } else {
            myRoles.add(rolesRepository.findById(1L).get());
            myRoles.add(rolesRepository.findById(2L).get());
            user.setRoles(myRoles);
            myUserRepository.save(user);
        }

    return"role ajouté";
}

}
