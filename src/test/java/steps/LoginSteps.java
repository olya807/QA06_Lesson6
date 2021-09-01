package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.LoginPage;

public class LoginSteps extends BaseStep {

    public LoginSteps(BrowsersService browsersService) {
        super(browsersService);
    }

    public ProductSteps successLogin(User user) {
        new LoginPage(browsersService, true)
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginBtnClick();

        return new ProductSteps(browsersService);
    }

    public LoginSteps incorrectLogin(User user) {
        new LoginPage(browsersService, true)
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .successLoginBtnClick();

        return this;
    }
}
