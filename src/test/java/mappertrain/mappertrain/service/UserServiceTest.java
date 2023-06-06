package mappertrain.mappertrain.service;

import mappertrain.mappertrain.entity.MyUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {


    UserService userService = new UserService();

    MyUser user1 = new MyUser("razzak.khalfallah@sncf.fr", "Razzak", "khalfallah");
    MyUser user2 = new MyUser("razzak.khalfallah@sncf.fr", "abdel", "khalfallah");
    MyUser user3 = new MyUser("razzak.khalfallah@sncf.fr", "sofiane", "khalfallah");
    @Test
    @DisplayName("si le prénom est razzak on return true sinon false")
    public void itShouldReturnTrueIfFirstIsRazzak(){
        assertAll("razzak",
                () -> assertEquals("yes", userService.isRazzak(user1.getFirstname())),
                () -> assertEquals("mince", userService.isRazzak(user2.getFirstname())));
    }

}