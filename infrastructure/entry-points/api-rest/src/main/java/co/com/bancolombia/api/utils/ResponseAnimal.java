package co.com.bancolombia.api.utils;

import co.com.bancolombia.model.animal.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseAnimal extends ResponseEntity<Animal> {
    private String msgAnimal;


    public ResponseAnimal(Animal animal, HttpStatus code, String message) {
        super(animal,code);
        this.msgAnimal = message;
    }

    public String getMsg() {
        return msgAnimal;
    }

}
