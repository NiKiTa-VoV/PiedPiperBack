package ru.skzmk.backend.general.message.realization.user.auth;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */

public class SignUpRequest {

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
