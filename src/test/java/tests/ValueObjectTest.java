package tests;

import baseEntities.BaseTest;
import models.Singleton;
import models.User;
import models.UserBuilder;
import org.testng.annotations.Test;
import steps.LoginSteps;

public class ValueObjectTest extends BaseTest {

    @Test
    public void valueObjectTest1(){

        User user = setUpUser();

        LoginSteps loginSteps = new LoginSteps(browserService);
        loginSteps.loginWithCorrectCredentials(user);

        System.out.println(user.getFirstName() + " " + user.getLastName());
    }

    @Test
    public void singletonTest(){
        System.out.println(Singleton.getInstance());
    }

    private User setUpUser(){

        User user = new User();
        user.setEmail("atrostyanko+0601@gmail.com");
        user.setPassword("hYE/RiquvQVIzXfiBwm3");
        user.setFirstName("Alexandr");
        user.setLastName("Trostyanko");

        return user;
    }

    private UserBuilder setUpUserBuilder(){

        UserBuilder user = new UserBuilder.Builder()
                .withFirstName("Alexandr")
                .withLastName("Trostyanko")
                .withEmail("atrostyanko+0601@gmail.com")
                .withPassword("hYE/RiquvQVIzXfiBwm3")
                .build();

        return user;
    }
}
