package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Run {
    @SerializedName(value = "name")
    private String runName;
    @SerializedName(value = "source")
    private String runSource;
}