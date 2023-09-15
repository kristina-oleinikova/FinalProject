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
}
