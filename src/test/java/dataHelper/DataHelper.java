package dataHelper;

import com.github.javafaker.Faker;
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
    public static Project getAddProject() {
        Project project = new Project();
        Faker faker = new Faker();
        project.setName(faker.name().name());
        project.setSummary(faker.name().name());
        return project;
    }
}
