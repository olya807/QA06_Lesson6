package models;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private boolean emailNotifications;
    private String language;
    private String password;

    public static class Builder {

        private UserBuilder newUser;

        public Builder() {
            newUser = new UserBuilder();
        }

        public Builder withFirstName(String firstName){

            newUser.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){

            newUser.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email){

            newUser.email = email;
            return this;
        }

        public Builder withPassword(String password){

            newUser.password = password;
            return this;
        }

        public UserBuilder build(){

            return newUser;
        }
    }
}
