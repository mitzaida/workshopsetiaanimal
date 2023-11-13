package co.com.bancolombia.api;

import co.com.bancolombia.api.utils.ResponseAnimal;
import co.com.bancolombia.model.animal.Animal;
import co.com.bancolombia.usecase.animalcase.AnimalCaseUseCase;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
@AllArgsConstructor
public class ApiRestController {

    private AnimalCaseUseCase useCase;

   @PostMapping(path = "/createAnimal")
    public ResponseAnimal createAnimal(@RequestBody Animal animal) {

       ResponseAnimal responseAnimal;
       System.out.println("Creating Animal - From ApiRestController EP.");

        try {
            Animal animal1 =  useCase.createAnimal(animal);

            responseAnimal = new ResponseAnimal(animal1, HttpStatus.CREATED,
                    "New Animal was Created SUCCESSFULLY.");
            System.out.println("**** "  + HttpStatus.CREATED);

        } catch (Exception e) {
            String msg = e.getMessage();

            responseAnimal = new ResponseAnimal(animal, HttpStatus.UNPROCESSABLE_ENTITY,
                    msg);
            System.out.println(msg);
        }
       return responseAnimal;
    }



    @GetMapping(path = "/animalById/{id}")
    public ResponseAnimal findAnimalById(@PathVariable String id) throws IOException {

        System.out.println("Finding Animal by id - From EP.");
        ResponseAnimal responseAnimal;

        try {
            Animal animal = useCase.findAnimalById(id);
            responseAnimal = new ResponseAnimal(animal, HttpStatus.FOUND,
                    "Animal founded.");
            System.out.println("**** " + HttpStatus.FOUND);
            return responseAnimal;

        } catch (Exception e) {
            String msg = e.getMessage();
            responseAnimal = new ResponseAnimal(null, HttpStatus.NOT_FOUND,
                    msg);
            System.out.println(msg + " " + HttpStatus.NOT_FOUND);

            return responseAnimal;
        }

    }




    @SneakyThrows
    @PutMapping(path = "/updateAnimal/{id}")
    public ResponseAnimal updateAnimal(@PathVariable String id, @RequestBody Animal animal)  {

        ResponseAnimal responseAnimal;
        System.out.println("Updating Animal - From ApiRestController EP.");

        try {
            Animal animal1 = useCase.updateAnimalById(id, animal);
            responseAnimal = new ResponseAnimal(animal1, HttpStatus.ACCEPTED,
                                    "**** Animal was Updated Successfully.");
            System.out.println("**** " + HttpStatus.ACCEPTED);

        } catch(Exception e) {
            String msg = e.getMessage();
            // Genera BAD_REQUEST por id null or name missing.
             responseAnimal = new ResponseAnimal(null,  HttpStatus.BAD_REQUEST,
                                    msg);
            System.out.println(msg);
        }

        return responseAnimal;
    }



    @DeleteMapping(path = "/deleteAnimal/{id}")
    public boolean deleteAnimalById(@PathVariable String id) {

         return useCase.deleteAnimalById(id);
    }



    @GetMapping(path = "/listAnimal/")
     public List<Animal> getAllAnimal() {

        List<Animal> animalList = useCase.getAllAnimal();
        return animalList;
    }

}
