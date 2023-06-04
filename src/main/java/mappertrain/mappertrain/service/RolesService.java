package mappertrain.mappertrain.service;

import mappertrain.mappertrain.entity.Roles;
import mappertrain.mappertrain.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

    @Autowired
    RolesRepository rolesRepository;
    public String deleteMyRole(Long id){
        rolesRepository.deleteById(id);
        return "role supprimé";
    }

    public Roles createRole(Roles role){
        rolesRepository.save(role);
        return role;
    }


}
