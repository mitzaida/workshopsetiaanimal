package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.AnimalEntity;
import co.com.bancolombia.jpa.helper.AdapterOperations;
import co.com.bancolombia.model.animal.Animal;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class AnimalJPARepositoryAdapter
        extends AdapterOperations<
            Animal,
            AnimalEntity,
            String,
            AnimalJPARepository>
{
    public AnimalJPARepositoryAdapter(AnimalJPARepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d,  Animal.class));
    }

}
