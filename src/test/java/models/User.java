package models;
import lombok.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private String email;
    private String password;
}
