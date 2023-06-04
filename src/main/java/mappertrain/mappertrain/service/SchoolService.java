package mappertrain.mappertrain.service;

import mappertrain.mappertrain.entity.School;
import mappertrain.mappertrain.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    public School createSchool(School school){
        return schoolRepository.save(school);
    }

    public School findSchool(Long id) throws Exception {
        if (schoolRepository.findById(id).isPresent()) {
            return schoolRepository.findById(id).get();
        } else {
            throw new Exception("can't find any school with this id");
        }

    }

    public String deleteSchool(Long id){
        schoolRepository.deleteById(id);
        return "Ecole supprimée";
    }
}
