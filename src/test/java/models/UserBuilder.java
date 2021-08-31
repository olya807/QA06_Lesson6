package models;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String postalCode;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public static class Builder {
        private UserBuilder userBuilder;

        public Builder() {

            userBuilder = new UserBuilder();
        }

        public Builder withFirstName(String firstName){

            userBuilder.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){

            userBuilder.lastName = lastName;
            return this;
        }

        public Builder withPostalCode(String postalCode){

            userBuilder.postalCode = postalCode;
            return this;
        }

        public UserBuilder build(){

            return userBuilder;
        }
    }
}
