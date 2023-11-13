package co.com.bancolombia.model.animal.gateways;

import co.com.bancolombia.model.animal.Animal;

import java.io.IOException;
import java.util.List;

public interface AnimalRepository {

    Animal createAnimal(Animal animal) throws Exception;
    Animal findAnimalById(String id) throws Exception;
    Animal updateAnimalById(String id, Animal animal) throws Exception;
    boolean deleteAnimalById(String id);

    List<Animal> getAllAnimal() ;

}
