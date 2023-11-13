package co.com.bancolombia.usecase.animalcase;

import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class AnimalCaseUseCase {

    private AnimalRepository animalRepository;


    public Animal createAnimal(Animal animal) throws Exception {

        animalRepository.createAnimal(animal);

        return  animal;
    }



    public Animal findAnimalById(String id) throws Exception{

        return animalRepository.findAnimalById(id);
    }



    public Animal updateAnimalById(String id, Animal animal) throws Exception {

            animalRepository.updateAnimalById(id, animal) ;

         return animal ;
    }


    public boolean deleteAnimalById(String id) {

         return animalRepository.deleteAnimalById(id);
    }


    public List<Animal> getAllAnimal() {

        return animalRepository.getAllAnimal();
    }
}
