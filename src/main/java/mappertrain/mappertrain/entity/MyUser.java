package mappertrain.mappertrain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mail;
    private String firstname;
    private String lastname;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Picture> pictures;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Roles> roles = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "school_id")
    private School school;

    public MyUser() {
    }

    public MyUser(String mail, String firstname, String lastname, List<Picture> pictures, List<Roles> roles, School school) {
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictures = pictures;
        this.roles = roles;
        this.school = school;
    }

    public MyUser(Long id, String mail, String firstname, String lastname, List<Picture> pictures, List<Roles> roles, School school) {
        this.id = id;
        this.mail = mail;
        this.firstname = firstname;
        this.lastname = lastname;
        this.pictures = pictures;
        this.roles = roles;
        this.school = school;
    }

    public Long getId() {
        return id;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
