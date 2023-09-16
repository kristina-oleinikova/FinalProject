package dataHelper;

import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {
    public static User getStandartUser() {
        User user = new User();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        return user;
}

    public static User getInvalidUser() {
        User user = new User();
        user.setEmail("invalidEmail");
        user.setPassword("invalidPassword");

        return user;
    }

}
