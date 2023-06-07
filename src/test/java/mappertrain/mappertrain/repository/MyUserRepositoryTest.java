package mappertrain.mappertrain.repository;
import mappertrain.mappertrain.entity.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class MyUserRepositoryTest {


    @Autowired
    private MyUserRepository myUserRepository;

    @Test
    public void shouldFindUserByMail(){
        MyUser utilisateur = new MyUser("razzak.khalfallah@sncf.fr", "khalfallah", "razzak");

        myUserRepository.saveAndFlush(utilisateur);

       Optional<MyUser> utilisateurPeutEtreRecupere = myUserRepository.findByMail(utilisateur.getMail());

        assertTrue(utilisateurPeutEtreRecupere.isPresent());
        // premier test qui vérifie que j'ai bien récupéré un utilisateur car isPresent() est sensé return true
        assertEquals(utilisateur.getMail(), utilisateurPeutEtreRecupere.get().getMail());
        // je test que le mail de l'utilisateur créé est le même que celui récupéré
        assertEquals(utilisateur.getFirstname(), utilisateurPeutEtreRecupere.get().getFirstname());
        // je test que le prenom de l'utilisateur créé est le même que celui récupéré
        assertEquals(utilisateur.getLastname(), utilisateurPeutEtreRecupere.get().getLastname());
        // je test que le nom de l'utilisateur créé est le même que celui récupéré

        // Si tous les test passent c'est qu'a priori j'ai récupéré la bonne entité et que findByMail fonctionne comme prévu

    }

}

