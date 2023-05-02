package helpers.models;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class UserDto {
    @JsonProperty(value = "username", access = JsonProperty.Access.READ_WRITE)
    private String username;
    @JsonProperty(value = "password", access = JsonProperty.Access.READ_WRITE)
    private String password;
    @JsonProperty(value = "firstname", access = JsonProperty.Access.READ_WRITE)
    private String firstname;
    @JsonProperty(value = "lastname", access = JsonProperty.Access.READ_WRITE)
    private String lastname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username) && Objects.equals(password, userDto.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

}
