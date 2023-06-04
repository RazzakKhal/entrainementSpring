package mappertrain.mappertrain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "roles", cascade = CascadeType.PERSIST)
    private List<MyUser> users = new ArrayList<>();

    public Roles() {
    }

    public Roles(String name) {
        this.name = name;

    }

    public Roles(String name, List<MyUser> users) {
        this.name = name;
        this.users = users;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MyUser> getUsers() {
        return users;
    }

    public void setUsers(List<MyUser> user) {
        this.users = user;
    }
}
