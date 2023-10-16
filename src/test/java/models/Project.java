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
}