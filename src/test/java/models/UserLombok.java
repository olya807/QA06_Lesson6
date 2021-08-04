package models;

import lombok.*;

@Data

public class UserLombok {
    String firstname;
    String lastname;
    String email;
    boolean emailNotification;
    String language;
    String password;
}
