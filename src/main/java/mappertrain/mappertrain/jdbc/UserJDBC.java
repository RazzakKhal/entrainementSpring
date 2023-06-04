package mappertrain.mappertrain.jdbc;

import mappertrain.mappertrain.entity.MyUser;
import mappertrain.mappertrain.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserJDBC {

    @Autowired
    DataSource dataSource;

    public Optional<MyUser> findUserById(Long id){
        try{
           Connection connection = dataSource.getConnection();
            PreparedStatement requetePreparee = connection.prepareStatement("SELECT * FROM my_user WHERE id = ?");
            requetePreparee.setLong(1, id);
            if(requetePreparee.executeQuery() != null) {
               ResultSet result = requetePreparee.executeQuery();

                while (result.next()) {
                    /*
                     Read results from ResultSet
                     */

                    String mail = result.getString("mail");
                    String lastname = result.getString("lastname");
                    String firstname = result.getString("firstname");


                    MyUser user = new MyUser();
                    user.setMail(mail);
                    user.setFirstname(firstname);
                    user.setLastname(lastname);


                    return Optional.of(user);
                }
            }


        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }



        return Optional.empty();
    }

}
