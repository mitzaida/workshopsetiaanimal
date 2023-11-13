package co.com.bancolombia.jpa;

import co.com.bancolombia.jpa.entities.AnimalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface AnimalJPARepository extends CrudRepository<AnimalEntity,  String>,
                                       QueryByExampleExecutor<AnimalEntity> {

}
