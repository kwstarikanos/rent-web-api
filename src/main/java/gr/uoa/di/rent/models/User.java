package gr.uoa.di.rent.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "users", schema = "rent")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "username",
        "name",
        "surname",
        "role",
        "birthday",
        "locked",
        "photo_profile"
})
public class User {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username", unique=true, nullable = false)
    @JsonProperty("username")
    private String username;

    @Column(name = "password", unique=true, nullable = false)
    @JsonProperty("password")
    private String password;

    @Column(name = "email", unique=true, nullable = false)
    @JsonProperty("email")
    private String email;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Column(name = "surname", nullable = false)
    @JsonProperty("surname")
    private String surname;

    @Column(name = "role", nullable = false)
    @JsonProperty("role")
    private Integer role;

    @Column(name = "birthday", nullable = false)
    @JsonProperty("birthday")
    private Date birthday;

    @Column(name = "locked", nullable = false)
    @JsonProperty("locked")
    private Boolean locked;

    @Column(name = "photo_profile")
    @JsonProperty("photo_profile")
    private String photo_profile;

    @OneToMany(mappedBy = "provider")
    private List<Hotel> hotels;

    public User() {
    }

    public User(String username, String password, String email, String name, String surname,
                Integer role, Date birthday, Boolean locked, String photo_profile) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.birthday = birthday;
        this.locked = locked;
        this.photo_profile = photo_profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getPhoto_profile() {
        return photo_profile;
    }

    public void setPhoto_profile(String photo_profile) {
        this.photo_profile = photo_profile;
    }
}