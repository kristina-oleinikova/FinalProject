package dataHelper;

import models.Project;
import models.User;
import utils.configuration.ReadProperties;

public class DataHelper {
    public static User getStandartUser() {
        User user = new User();
        user.setEmail(ReadProperties.email());
        user.setPassword(ReadProperties.password());

        return user;
    }
    public static Project getAddProject() {
        Project addProject = new Project.Builder()
                .withName("Project 1")
                .withSummary("This is a summary")
                .build();
        return addProject;
    }
}
