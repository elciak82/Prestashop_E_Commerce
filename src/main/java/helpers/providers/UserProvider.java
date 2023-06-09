package helpers.providers;

import helpers.models.UserDto;
import utils.objectmapper.JsonMapper;

import java.util.List;

public class UserProvider {

    public static List<UserDto> provideUsers() {
        return new JsonMapper().readAsDtoList("UserPool.json", UserDto.class);
    }

    public static UserDto provideUser(String username) {
        return provideUsers()
                .stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow();
    }

    }
