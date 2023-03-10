package project.models;

import java.util.Objects;

public class UserRole {

    private int id;
    private String login;
    private String firstName;
    private String lastName;

    private int idRole;
    private int idUser;
    private String name;



    public UserRole() {
    }

    public UserRole(int id, String login, String firstName, String lastName, int idRole, int idUser, String name) {
        this.id = id;
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idRole = idRole;
        this.idUser = idUser;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return id == userRole.id && idRole == userRole.idRole && idUser == userRole.idUser && Objects.equals(login, userRole.login) && Objects.equals(firstName, userRole.firstName) && Objects.equals(lastName, userRole.lastName) && Objects.equals(name, userRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, firstName, lastName, idRole, idUser, name);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idRole=" + idRole +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                '}';
    }
}
