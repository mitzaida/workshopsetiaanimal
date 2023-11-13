package co.com.bancolombia.model.animal;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Data
public class Animal {

    private String id;
    private String animalname;
    private String habitat;
    private boolean gender;
    private int numberpaws;
    private boolean domestic;

}
