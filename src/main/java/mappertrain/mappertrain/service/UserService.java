package mappertrain.mappertrain.service;

import mappertrain.mappertrain.entity.MyUser;
import mappertrain.mappertrain.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class UserService {

    @Autowired
    MyUserRepository myUserRepository;
    public List<MyUser> findAllUsers(){


        return myUserRepository.findAll();
    }

    public MyUser createUser(MyUser user){
        myUserRepository.save(user);

        return user;
    }

    public String deleteUser(Long id){
        myUserRepository.deleteById(id);
        return "Utilisateur supprimé";
    }

    public String isRazzak(String prenom){
        if(prenom.equals("Razzak")){ return "yes";}
        return "mince";
    }
}
