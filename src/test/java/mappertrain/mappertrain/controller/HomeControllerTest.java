package mappertrain.mappertrain.controller;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import mappertrain.mappertrain.MappertrainApplication;
import mappertrain.mappertrain.entity.MyUser;
import mappertrain.mappertrain.jdbc.UserJDBC;
import mappertrain.mappertrain.repository.MyUserRepository;
import mappertrain.mappertrain.repository.RolesRepository;
import mappertrain.mappertrain.service.RolesService;
import mappertrain.mappertrain.service.SchoolService;
import mappertrain.mappertrain.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(HomeController.class)
@ContextConfiguration(classes = MappertrainApplication.class)
class HomeControllerTest {
    @MockBean
    private MyUserRepository myUserRepository;
    @MockBean
    RolesRepository rolesRepository;
    @MockBean
    UserService userService;
    @MockBean
    SchoolService schoolService;

    @MockBean
    RolesService rolesService;

    @MockBean
    UserJDBC userJDBC;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void shouldFindUserById() throws Exception {

        // on redéfinit le comportement de myUserRepository
        MyUser utilisateur = new MyUser("razzak@gmail.com", "razzak", "khalfallah");

        // quand ce repository fais findById(1L) alors on retourne l'instance du dessus.
        // ( donc findById n'aura pas besoin de BDD)
        when(myUserRepository.findById(1L)).thenReturn(Optional.of(utilisateur));


        mockMvc.perform(get("/findUser/1"))
                .andExpect(status().isOk())
                // je test que le status de la réponse est 200 (success)
                .andExpect(jsonPath("$.firstname").value("razzak"));
                // je vérifie que la valeur de la proriété firstname de l'utilisateur 1  est razzak
                 // (selectionné utilisateur 11 à l'aide de findUser/1)
    }


}

