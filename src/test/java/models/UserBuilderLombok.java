package models;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class UserBuilderLombok {

    String firstname;
    String lastname;
    String email;
    boolean emailNotification;
    String language;
    String password;
}
