package dataHelper;

import models.User;
import models.Project;
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
    public static Project getAddProject(String name, String summary) {
        Project addProject = new Project.Builder()
                .withName(name)
                .withSummary(summary)
                .build();
        return addProject;
    }
}
