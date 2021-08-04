package tests;

import models.UserBuilderLombok;
import models.UserLombok;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LombokTest {

    @Test
    public void lombokToStringTest() {
        UserLombok userLombok = new UserLombok();

        System.out.println(userLombok.toString());
    }

    @Test
    public void lombokEqualsTest() {
        UserLombok userLombok1 = new UserLombok();
        UserLombok userLombok2 = new UserLombok();

        userLombok1.setFirstname("Саша");
        userLombok2.setFirstname("Саша");

        Assert.assertEquals(userLombok1, userLombok2);
    }

    @Test
    public void lombokBuilderTest() {
        UserBuilderLombok userBuilderLombok = new UserBuilderLombok.builder()
                .firstname("Саша ")
                .lastname("Тростянко")
                .build();
        UserBuilderLombok userBuilderLombok2 = new UserBuilderLombok.builder()
                .firstname("Саша ")
                .lastname("Тростянко")
                .build();

        System.out.println(userBuilderLombok.toString());
        Assert.assertEquals(userBuilderLombok, userBuilderLombok2);

    }
}
