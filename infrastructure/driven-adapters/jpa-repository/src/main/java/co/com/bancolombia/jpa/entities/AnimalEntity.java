package co.com.bancolombia.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "animal")
public class AnimalEntity {
    @Id private String id;
    @Column(nullable = true, length = 250) private String animalname;
    @Column(nullable = false, length = 350) private String habitat;
    @Column(nullable = true) private boolean gender;
    @Column(nullable = false, length = 50) private int numberpaws;
    @Column(nullable = true) private boolean domestic;
}
