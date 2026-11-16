
package com.ridex.dto;

public class UserResponseDTO {

    private Integer userId;
    private String email;
    private String role;

    public UserResponseDTO(Integer userId, String email, String role) {
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
