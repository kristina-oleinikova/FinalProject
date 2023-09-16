package models;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Project {
    private String name;
    private String summary;

    public static class Builder {
        private Project newProject;

        public Builder() {
            this.newProject = new Project();
        }
        public Builder withName(String name) {
            newProject.name = name;
            return this;
        }
        public Builder withSummary(String summary) {
            newProject.summary = summary;
            return this;
        }
        public Project build() {
            return newProject;
        }
    }
}