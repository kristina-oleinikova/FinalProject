package models;
import com.github.javafaker.Faker;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Project {
    private String name;
    private String summary;

//    public static class Builder {
//        Faker faker = new Faker();
//        private Project newProject;
//
//        public Builder() {
//            this.newProject = new Project();
//        }
//        public Builder withName() {
//            newProject.name = faker.name().name();
//            return this;
//        }
//        public Builder withSummary() {
//            newProject.summary = faker.name().name();
//            return this;
//        }
//        public Project build() {
//            return newProject;
//        }
//    }
}