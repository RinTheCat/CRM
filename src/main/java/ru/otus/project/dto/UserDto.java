package ru.otus.project.dto;

import ru.otus.project.domain.User;

public class UserDto {

    private String userName;

    public UserDto(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User toDomainObject() {
        return null;
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getUsername());
    }
}
