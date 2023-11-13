package co.com.bancolombia.jpa;

import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.model.animal.gateways.AnimalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AnimalJPAImpl implements AnimalRepository {

    private AnimalJPARepositoryAdapter  animalJPARepositoryAdapter;

    @Override
    public Animal createAnimal(Animal animal) throws IOException {

        //Se valida que el nombre no esté vacío para poder grabar el Animal.
        if(!animal.getAnimalname().isEmpty()) {
            String id = UUID.randomUUID().toString();
            animal.setId(id);
            animalJPARepositoryAdapter.save(animal);
            return animal;

        } else {
            animal.setAnimalname("");
            animal.setHabitat("");
            animal.setGender(false);
            animal.setNumberpaws(0);
            animal.setDomestic(false);
            throw new IOException("---- Can't create this Animal. Name is missing - From Impl.");
        }
    }


    @Override
    public Animal findAnimalById(String id) throws IOException {

        Animal animal = animalJPARepositoryAdapter.findById(id);

        if(animal != null) {
            //return animalOptional.orElse(null);
            return animal;
        } else {
            throw new IOException("Animal Id: " + id + " Doesn't Exists.");
        }
    }


    @Override
    public Animal updateAnimalById(String id, Animal animal) throws IOException {
        Animal animal1 = animalJPARepositoryAdapter.findById(id);

        if(animal1 == null) {
            animal.setAnimalname("");
            animal.setHabitat("");
            animal.setGender(false);
            animal.setNumberpaws(0);
            animal.setDomestic(false);
            throw new IOException("---- Can't UPDATE, this Animal Does Not Exists. From Impl." + id);
        }

        if(!animal.getAnimalname().isEmpty()) {
           return animalJPARepositoryAdapter.save(animal);
        } else {
            throw new IOException("---- Can't UPDATE because Name to update is missing. From Impl." + id);
        }

    }

    @Override
    public boolean deleteAnimalById(String id) {
        Animal animal = animalJPARepositoryAdapter.findById(id);

        if(animal != null) {
            animalJPARepositoryAdapter.deleteById(id);

            return true;
        }

        return false;

    }

    @Override
    public List<Animal> getAllAnimal()  {

        List<Animal> animalList = animalJPARepositoryAdapter.findAll();

        if(animalList.isEmpty()) {
            new IOException("---- Empty Animal List from Impl.");
        }

        return animalList;
    }

}
